package com.encomienda.app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.encomienda.app.models.entity.Categoria;
import com.encomienda.app.models.entity.OrdenDeEnvio;
import com.encomienda.app.models.entity.Paquete;
import com.encomienda.app.services.interfaces.ICategoriaService;
import com.encomienda.app.services.interfaces.IOrdenDeEnvioService;
import com.encomienda.app.services.interfaces.IPaqueteService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class GestionarRecepcionDePaqueteService {
	
	@Autowired
	private IPaqueteService paqueteService;
	@Autowired
	private ICategoriaService categoriaService;
	@Autowired
	private IOrdenDeEnvioService ordenDeEnvioService;
	
	private Categoria obtenerCategoria(Paquete paquete) 
	{
		List<Categoria> categorias = categoriaService.findAll();
		
		for (Categoria categoria : categorias) {
			if(categoria.getPesoMaximo() >= paquete.getPeso() && categoria.getPesoMinimo() <= paquete.getPeso()) {
				return categoria;
			}
		}
		return null;
	}

	@PostMapping("/gestionarRecepcionDePaquetes/paquete")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Paquete> cotizarPaquete(@RequestBody List<Paquete> paquetes)
	{
		Long iterador = 1l;
		List<Paquete> paquetesProcesados = new ArrayList<Paquete>();
		for (Paquete paquete : paquetes) {
			Categoria categoria = obtenerCategoria(paquete);
			paquete.setCategoria(categoria);
			paquete.setCodigo(iterador.toString());
			Long numeroDePaquete = paqueteService.countRows();
			paquete.generarCodigoPaquete(numeroDePaquete);
			paquetesProcesados.add(paquete);
			iterador++;
		}
		
		return paquetesProcesados;
	}
	
	@PostMapping("/gestionarRecepcionDePaquetes/orden")
	@ResponseStatus(HttpStatus.CREATED)
	public OrdenDeEnvio procesarOrdenDeEnvio(@RequestBody OrdenDeEnvio ordenDeEnvio)
	{
		Long numeroDeOrden = ordenDeEnvioService.countRows()+1;
		ordenDeEnvio.generarCodigoOrden(numeroDeOrden); 
		ordenDeEnvio.generarClaveOrden(numeroDeOrden);
		ordenDeEnvio.calcularPrecioTotal();
		ordenDeEnvio.generarFecha();
		return ordenDeEnvio;
	}
	
	private void guardarPaquetes(List<Paquete> paquetesProcesados,OrdenDeEnvio ordenDeEnvioGuardada) {
		
		for (Paquete paquete : paquetesProcesados ) {
			
			if(paquete.validarCategoria() == true) {
				
				paquete.setOrdenDeEnvio(ordenDeEnvioGuardada);
				paqueteService.save(paquete);
			
			}
		}
	}
	
	@PostMapping("/gestionarRecepcionDePaquetes/guardar")
	@ResponseStatus(HttpStatus.CREATED)
	public OrdenDeEnvio guardarOrdenDeEnvio(@RequestBody OrdenDeEnvio ordenDeEnvio) {
		
		List<Paquete> paquetesProcesados = new ArrayList<Paquete>(ordenDeEnvio.getPaquetes());
		ordenDeEnvio.getPaquetes().clear();
		OrdenDeEnvio ordenDeEnvioGuardada = ordenDeEnvioService.save(ordenDeEnvio);
		guardarPaquetes(paquetesProcesados, ordenDeEnvioGuardada);
		return ordenDeEnvioGuardada;
	}
	
}

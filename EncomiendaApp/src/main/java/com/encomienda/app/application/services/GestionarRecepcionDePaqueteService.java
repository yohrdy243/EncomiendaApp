package com.encomienda.app.application.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.encomienda.app.domain.contracts.ICategoria;
import com.encomienda.app.domain.contracts.ICliente;
import com.encomienda.app.domain.contracts.IOrdenDeEnvio;
import com.encomienda.app.domain.contracts.IPaquete;
import com.encomienda.app.domain.contracts.IRuta;
import com.encomienda.app.domain.contracts.ISucursal;
import com.encomienda.app.domain.entities.Categoria;
import com.encomienda.app.domain.entities.Cliente;
import com.encomienda.app.domain.entities.OrdenDeEnvio;
import com.encomienda.app.domain.entities.Paquete;
import com.encomienda.app.domain.entities.Ruta;
import com.encomienda.app.domain.entities.Sucursal;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class GestionarRecepcionDePaqueteService {
	
	@Autowired
	private IPaquete paqueteService;
	@Autowired
	private ICategoria categoriaService;
	@Autowired
	private IOrdenDeEnvio ordenDeEnvioService;
	@Autowired
	private ICategoria categoriaServices;
	@Autowired
	private ICliente clienteServices;
	@Autowired
	private ISucursal sucursalServices;
	@Autowired
	private IRuta rutaServices;
	
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
	public List<Paquete> cotizarPaquetes(@RequestBody List<Paquete> paquetes)
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
	
	@GetMapping("/categorias/pesoMaximo")
	public Categoria buscarCategoriaConElPesoMaximoMasAlto() {
		return categoriaServices.buscarCategoriaConElPesoMaximoMasAlto();
	}
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes(){
		return clienteServices.findAll();
	}
		
	@GetMapping("rutas/buscar/{idSucursalEmisor}/{idSucursalReceptor}")
	public Ruta buscarRutaPorId(@PathVariable Long idSucursalEmisor,@PathVariable Long idSucursalReceptor) {
		Sucursal sucursalEmisor = sucursalServices.findById(idSucursalEmisor);
		Sucursal sucursalReceptor = sucursalServices.findById(idSucursalReceptor);
		return rutaServices.findBySucursalEmisorAndSucursalReceptor(sucursalEmisor, sucursalReceptor);
	}

	@GetMapping("/sucursales")
	public List<Sucursal> listarSucursales(){
		return sucursalServices.findAll();
	}
	
}

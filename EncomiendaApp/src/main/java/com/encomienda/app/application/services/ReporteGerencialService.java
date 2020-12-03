package com.encomienda.app.application.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encomienda.app.domain.contracts.ICategoria;
import com.encomienda.app.domain.contracts.IPaquete;
import com.encomienda.app.domain.entities.Categoria;
import com.encomienda.app.domain.entities.Paquete;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class ReporteGerencialService {
	
	@Autowired
	private IPaquete paqueteService;
	@Autowired
	private ICategoria categoriaServices;
	
	@GetMapping("/reporteGerencial/sucursal/{idSucursal}")
	public List<Paquete> reportePorSucursal(@PathVariable Long idSucursal) {
		List<Paquete> paquetes = paqueteService.findByOrdenDeEnvio_Ruta_SucursalEmisor_IdSucursal(idSucursal); 
		
		return paquetes;
	}
	
	@GetMapping("/reporteGerencial/categoria/{idCategoria}")
	public List<Paquete> reportePorCategoria(@PathVariable Long idCategoria) {
		
		List<Paquete> paquetes = paqueteService.findByCategoria_IdCategoria(idCategoria);
		
		return paquetes;
	}
	
	@GetMapping("/categorias")
	private List<Categoria> listarCategorias(){
		return categoriaServices.findAll();
	}
	

	
}

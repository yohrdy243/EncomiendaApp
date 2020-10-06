package com.encomienda.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.encomienda.app.models.entity.OrdenDeEnvio;
import com.encomienda.app.models.entity.Paquete;
import com.encomienda.app.models.entity.Ruta;
import com.encomienda.app.services.OrdenDeEnvioService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class OrdenDeEnvioController {
	
	@Autowired
	private OrdenDeEnvioService ordenDeEnvioServices;
	
	@GetMapping("/ordenDeEnvios")
	private List<OrdenDeEnvio> listarOrdenDeEnvios(){
		return ordenDeEnvioServices.findAll();
	}
	
	@GetMapping("ordenDeEnvios/{id}")
	public OrdenDeEnvio buscarOrdenDeEnvioPorId(@PathVariable Long idOrdenDeEnvio) {
		return ordenDeEnvioServices.findById(idOrdenDeEnvio);
	}
	
	@PostMapping("/ordenDeEnvios")
	@ResponseStatus(HttpStatus.CREATED)
	public OrdenDeEnvio crearOrdenDeEnvio(@RequestBody OrdenDeEnvio ordenDeEnvio) {
		return ordenDeEnvioServices.save(ordenDeEnvio);
	}
	
	@PutMapping("/ordenDeEnvios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public OrdenDeEnvio actualizarOrdenDeEnvio(@RequestBody OrdenDeEnvio ordenDeEnvio,@PathVariable Long id) {
		
		OrdenDeEnvio ordenDeEnvioActual = ordenDeEnvioServices.findById(id);
		
		Ruta nuevaRuta = ordenDeEnvio.getRuta();
		ordenDeEnvioActual.setRuta(nuevaRuta);
		
		List<Paquete> nuevosPaquetes = ordenDeEnvio.getPaquetes();
		ordenDeEnvioActual.setPaquetes(nuevosPaquetes);
		
		ordenDeEnvioActual.calcularPrecioTotal();
		
		return ordenDeEnvioServices.save(ordenDeEnvioActual); 
	}
	
	@DeleteMapping("/ordenDeEnvio/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		ordenDeEnvioServices.deletebyId(id);
	}
	
	
}
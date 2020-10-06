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
import com.encomienda.app.models.entity.Ruta;
import com.encomienda.app.services.RutaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class RutaController {
	
	@Autowired
	private RutaService rutaServices;
	
	@GetMapping("/rutas")
	private List<Ruta> listarRutas(){
		return rutaServices.findAll();
	}
	
	@GetMapping("rutas/{id}")
	public Ruta buscarRutaPorId(@PathVariable Long idRuta) {
		return rutaServices.findById(idRuta);
	}
	
	@PostMapping("/rutas")
	@ResponseStatus(HttpStatus.CREATED)
	public Ruta crearRuta(@RequestBody Ruta ruta) {
		return rutaServices.save(ruta);
	}
	
	@PutMapping("/rutas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Ruta actualizarRuta(@RequestBody Ruta ruta,@PathVariable Long id) {
		
		Ruta rutaActual = rutaServices.findById(id);
		
		return rutaServices.save(rutaActual); 
	}
	
	@DeleteMapping("/ruta/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		rutaServices.deletebyId(id);
	}
	
	
}
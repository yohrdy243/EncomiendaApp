package com.encomienda.app.services;

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

import com.encomienda.app.models.entity.Paquete;
import com.encomienda.app.services.interfaces.IPaqueteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class PaqueteService {
	
	@Autowired
	private IPaqueteService paqueteServices;
	
	@GetMapping("/paquetes")
	private List<Paquete> listarPaquetes(){
		System.out.print(paqueteServices.countRows()+"holaaaaaaaaaaaa");
		return paqueteServices.findAll();
		
	}
	
	@GetMapping("paquetes/{id}")
	public Paquete buscarPaquetePorId(@PathVariable Long idPaquete) {
		return paqueteServices.findById(idPaquete);
	}
	
	@PostMapping("/paquetes")
	@ResponseStatus(HttpStatus.CREATED)
	public Paquete crearPaquete(@RequestBody Paquete paquete) {
		if(paquete.validarCategoria() == true) {
			paquete.setEstado(true);
			return paqueteServices.save(paquete);
		}
		return null;
	}
	
	@PutMapping("/paquetes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Paquete actualizarPaquete(@RequestBody Paquete paquete,@PathVariable Long id) {
		
		Paquete paqueteActual = paqueteServices.findById(id);
		
		boolean nuevoEstado = paquete.isEstado();
		paqueteActual.setEstado(nuevoEstado);
		
		float nuevoPeso = paquete.getPeso();
		paqueteActual.setPeso(nuevoPeso);
		
		String nuevaDescripcion = paquete.getDescripcion();
		paqueteActual.setDescripcion(nuevaDescripcion);
		
		return paqueteServices.save(paqueteActual); 
	}
	
	@DeleteMapping("/paquete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		paqueteServices.deletebyId(id);
	}
	
	
}
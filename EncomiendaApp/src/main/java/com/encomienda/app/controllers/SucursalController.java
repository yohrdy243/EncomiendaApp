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

import com.encomienda.app.models.entity.Sucursal;
import com.encomienda.app.services.SucursalService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class SucursalController {
	
	@Autowired
	private SucursalService sucursalServices;
	
	@GetMapping("/sucursals")
	private List<Sucursal> listarSucursals(){
		return sucursalServices.findAll();
	}
	
	@GetMapping("sucursals/{id}")
	public Sucursal buscarSucursalPorId(@PathVariable Long idSucursal) {
		return sucursalServices.findById(idSucursal);
	}
	
	@PostMapping("/sucursals")
	@ResponseStatus(HttpStatus.CREATED)
	public Sucursal crearSucursal(@RequestBody Sucursal sucursal) {
		return sucursalServices.save(sucursal);
	}
	
	@PutMapping("/sucursals/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Sucursal actualizarSucursal(@RequestBody Sucursal sucursal,@PathVariable Long id) {
		
		Sucursal sucursalActual = sucursalServices.findById(id);		
		return sucursalServices.save(sucursalActual); 
	}
	
	@DeleteMapping("/sucursal/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		sucursalServices.deletebyId(id);
	}
	
	
}
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

import com.encomienda.app.models.entity.Sucursal;
import com.encomienda.app.services.interfaces.ISucursalService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class SucursalController {
	
	@Autowired
	private ISucursalService sucursalServices;
	
	@GetMapping("/sucursales")
	public List<Sucursal> listarSucursales(){
		return sucursalServices.findAll();
	}
	
	@GetMapping("sucursales/{id}")
	public Sucursal buscarSucursalPorId(@PathVariable Long idSucursal) {
		return sucursalServices.findById(idSucursal);
	}
	@GetMapping("sucursales/nombre/{nombre}")
	public Sucursal buscarSucursalPorId(@PathVariable String nombre) {
		return sucursalServices.findByNombre(nombre);
	}
	
	@PostMapping("/sucursales")
	@ResponseStatus(HttpStatus.CREATED)
	public Sucursal crearSucursal(@RequestBody Sucursal sucursal) {
		return sucursalServices.save(sucursal);
	}
	
	@PutMapping("/sucursales/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Sucursal actualizarSucursal(@RequestBody Sucursal sucursal,@PathVariable Long id) {
		
		Sucursal sucursalActual = sucursalServices.findById(id);		
		return sucursalServices.save(sucursalActual); 
	}
	
	@DeleteMapping("/sucursales/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		sucursalServices.deletebyId(id);
	}
	
	
}
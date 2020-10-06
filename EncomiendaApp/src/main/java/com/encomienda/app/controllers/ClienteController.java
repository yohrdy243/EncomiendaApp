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

import com.encomienda.app.models.entity.Cliente;
import com.encomienda.app.services.ClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteServices;
	
	@GetMapping("/clientes")
	private List<Cliente> listarClientes(){
		return clienteServices.findAll();
	}
	
	@GetMapping("clientes/{id}")
	public Cliente buscarClientePorId(@PathVariable Long idCliente) {
		return clienteServices.findById(idCliente);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		return clienteServices.save(cliente);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente actualizarCliente(@RequestBody Cliente cliente,@PathVariable Long id) {
		
		Cliente clienteActual = clienteServices.findById(id);
		
		String nuevoNombre = cliente.getNombres();
		clienteActual.setNombres(nuevoNombre);
		
		String nuevoApellidos = cliente.getApellidos();
		clienteActual.setApellidos(nuevoApellidos);
		
		Long nuevoTelefono = cliente.getTelefono();
		clienteActual.setTelefono(nuevoTelefono);
		
		String nuevoCorreo = cliente.getCorreo();
		clienteActual.setCorreo(nuevoCorreo);
		
		return clienteServices.save(clienteActual); 
	}
	
	@DeleteMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteServices.deletebyId(id);
	}
	
	
}
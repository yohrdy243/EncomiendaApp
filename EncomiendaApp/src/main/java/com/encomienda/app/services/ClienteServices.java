package com.encomienda.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.encomienda.app.models.entity.Cliente;
import com.encomienda.app.services.interfaces.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class ClienteServices {
	
	@Autowired
	private IClienteService clienteServices;
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes(){
		return clienteServices.findAll();
	}
	
	@GetMapping("clientes/{dni}")
	public Cliente buscarClientePorDni(@PathVariable Long dni) {
		return clienteServices.findByDni(dni);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente crearCliente(@RequestBody Cliente cliente) {
		cliente.setHabilitado(true);
		return clienteServices.save(cliente);
	}
	
	@PutMapping("/clientes/{dni}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente actualizarCliente(@RequestBody Cliente cliente,@PathVariable Long dni) {
		
		Cliente clienteActual = clienteServices.findByDni(dni);
		
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
	
	@PutMapping("/clientes/deshabilitar/{dni}")
	@ResponseStatus(HttpStatus.CREATED)
	public void deshabilitarCliente(@PathVariable Long dni) {
		
		Cliente clienteDeshabilitado =clienteServices.findByDni(dni);
		clienteDeshabilitado.setHabilitado(false);
		clienteServices.save(clienteDeshabilitado);
	}
	
	
}
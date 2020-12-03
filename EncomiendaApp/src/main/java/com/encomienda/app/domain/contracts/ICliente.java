package com.encomienda.app.domain.contracts;
import java.util.List;

import com.encomienda.app.domain.entities.Cliente;


public interface ICliente {

	public List<Cliente> obtenerClientes();
	public Cliente guardarCliente(Cliente cliente);
	public Cliente buscarCliente(Long dni);
	public void borrarCliente(Long id);

}

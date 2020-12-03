package com.encomienda.app.domain.contracts;
import java.util.List;

import com.encomienda.app.domain.entities.Cliente;


public interface ICliente {

	public List<Cliente> findAll();
	public Cliente save(Cliente cliente);
	public Cliente findById(Long dni);
	public void deletebyId(Long id);
	public Cliente findByDni (Long Dni);

}

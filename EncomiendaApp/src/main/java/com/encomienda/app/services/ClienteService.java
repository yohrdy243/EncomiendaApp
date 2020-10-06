package com.encomienda.app.services;
import java.util.List;
import com.encomienda.app.models.entity.Cliente;


public interface ClienteService {

	public List<Cliente> findAll();
	public Cliente save(Cliente cliente);
	public Cliente findById(Long idCliente);
	public void deletebyId(Long id);

}

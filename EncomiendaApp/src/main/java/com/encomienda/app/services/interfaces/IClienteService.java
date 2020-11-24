package com.encomienda.app.services.interfaces;
import java.util.List;
import com.encomienda.app.models.entity.Cliente;


public interface IClienteService {

	public List<Cliente> findAll();
	public Cliente save(Cliente cliente);
	public Cliente findById(Long dni);
	public void deletebyId(Long id);
	public Cliente findByDni (Long Dni);

}

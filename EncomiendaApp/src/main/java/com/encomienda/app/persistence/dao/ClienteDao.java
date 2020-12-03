package com.encomienda.app.persistence.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encomienda.app.domain.contracts.ICliente;
import com.encomienda.app.domain.entities.Cliente;
import com.encomienda.app.persistence.repositories.IClienteRepository;

@Service
public class ClienteDao implements ICliente {

	@Autowired
	private IClienteRepository clienteDao;
	@Transactional(readOnly = true)

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDao.findByHabilitado(true);
	}
	@Transactional
	@Override
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}
	@Transactional(readOnly = true)
	@Override
	public Cliente findById(Long idCliente) {
		return clienteDao.findById(idCliente).orElse(null);
	}

	@Transactional
	@Override
	public void deletebyId(Long id) {
		clienteDao.deleteById(id);
	}
	@Override
	public Cliente findByDni(Long Dni) {
		return clienteDao.findByDni(Dni);
	}

}

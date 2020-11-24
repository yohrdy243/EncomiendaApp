package com.encomienda.app.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encomienda.app.models.dao.IClienteDao;
import com.encomienda.app.models.entity.Cliente;
import com.encomienda.app.services.interfaces.IClienteService;

@Service
public class ClienteServicesImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
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

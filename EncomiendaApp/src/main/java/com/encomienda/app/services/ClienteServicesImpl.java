package com.encomienda.app.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encomienda.app.models.dao.IClienteDao;
import com.encomienda.app.models.entity.Cliente;

@Service
public class ClienteServicesImpl implements ClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteDao.findAll();
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	public Cliente findById(Long idCliente) {
		return clienteDao.findById(idCliente).orElse(null);
	}

	@Override
	public void deletebyId(Long id) {
		clienteDao.deleteById(id);
	}

}

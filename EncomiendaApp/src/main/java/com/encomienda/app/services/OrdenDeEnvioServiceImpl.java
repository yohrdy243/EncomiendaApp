package com.encomienda.app.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encomienda.app.models.dao.IOrdenDeEnvioDao;
import com.encomienda.app.models.entity.OrdenDeEnvio;

@Service
public class OrdenDeEnvioServiceImpl implements OrdenDeEnvioService{

	@Autowired
	private IOrdenDeEnvioDao ordenDeEnvioDao;
	
	@Override
	public List<OrdenDeEnvio> findAll() {
		return (List<OrdenDeEnvio>)ordenDeEnvioDao.findAll();
	}

	@Override
	public OrdenDeEnvio save(OrdenDeEnvio ordenDeEnvio) {
		return ordenDeEnvioDao.save(ordenDeEnvio);
	}

	@Override
	public OrdenDeEnvio findById(Long idOrdenDeEnvio) {
		return ordenDeEnvioDao.findById(idOrdenDeEnvio).orElse(null);
	}

	@Override
	public void deletebyId(Long id) {
		ordenDeEnvioDao.deleteById(id);
	}

}

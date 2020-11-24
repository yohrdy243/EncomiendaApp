package com.encomienda.app.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encomienda.app.models.dao.IOrdenDeEnvioDao;
import com.encomienda.app.models.entity.OrdenDeEnvio;
import com.encomienda.app.services.interfaces.IOrdenDeEnvioService;

@Service
public class OrdenDeEnvioServiceImpl implements IOrdenDeEnvioService{

	@Autowired
	private IOrdenDeEnvioDao ordenDeEnvioDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<OrdenDeEnvio> findAll() {
		return (List<OrdenDeEnvio>)ordenDeEnvioDao.findAll();
	}
	
	@Transactional
	@Override
	public OrdenDeEnvio save(OrdenDeEnvio ordenDeEnvio) {
		return ordenDeEnvioDao.save(ordenDeEnvio);
	}
	
	@Transactional(readOnly = true)
	@Override
	public OrdenDeEnvio findById(Long idOrdenDeEnvio) {
		return ordenDeEnvioDao.findById(idOrdenDeEnvio).orElse(null);
	}
	
	@Transactional
	@Override
	public void deletebyId(Long id) {
		ordenDeEnvioDao.deleteById(id);
	}
	
	@Transactional
	@Override
	public Long countRows() {
		return ordenDeEnvioDao.count();
	}

}

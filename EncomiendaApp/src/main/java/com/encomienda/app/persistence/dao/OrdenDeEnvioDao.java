package com.encomienda.app.persistence.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encomienda.app.domain.contracts.IOrdenDeEnvio;
import com.encomienda.app.domain.entities.OrdenDeEnvio;
import com.encomienda.app.persistence.repositories.IOrdenDeEnvioRepository;

@Service
public class OrdenDeEnvioDao implements IOrdenDeEnvio{

	@Autowired
	private IOrdenDeEnvioRepository ordenDeEnvioDao;
	
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

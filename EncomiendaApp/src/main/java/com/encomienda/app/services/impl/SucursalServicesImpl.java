package com.encomienda.app.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encomienda.app.models.dao.ISucursalDao;
import com.encomienda.app.models.entity.Sucursal;
import com.encomienda.app.services.interfaces.ISucursalService;

@Service
public class SucursalServicesImpl implements ISucursalService {

	@Autowired
	private ISucursalDao sucursalDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Sucursal> findAll() {
		return (List<Sucursal>)sucursalDao.findAll();
	}
	@Transactional
	@Override
	public Sucursal save(Sucursal sucursal) {
		return sucursalDao.save(sucursal);
	}
	@Transactional(readOnly = true)
	@Override
	public Sucursal findById(Long idSucursal) {
		return sucursalDao.findById(idSucursal).orElse(null);
	}
	@Transactional
	@Override
	public void deletebyId(Long id) {
		sucursalDao.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Sucursal findByNombre(String nombre) {
		return sucursalDao.findByNombre(nombre);
	}

}

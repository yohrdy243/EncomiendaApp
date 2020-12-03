package com.encomienda.app.persistence.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encomienda.app.domain.contracts.ISucursal;
import com.encomienda.app.domain.entities.Sucursal;
import com.encomienda.app.persistence.repositories.ISucursalRepository;

@Service
public class SucursalDao implements ISucursal {

	@Autowired
	private ISucursalRepository sucursalDao;
	
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

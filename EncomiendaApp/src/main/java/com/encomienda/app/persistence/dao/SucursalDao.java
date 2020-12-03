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
	public List<Sucursal> obtenerSucursales() {
		return (List<Sucursal>)sucursalDao.findAll();
	}
	@Transactional
	@Override
	public Sucursal guardarSucursal(Sucursal sucursal) {
		return sucursalDao.save(sucursal);
	}
	@Transactional(readOnly = true)
	@Override
	public Sucursal buscarSucursal(Long idSucursal) {
		return sucursalDao.findById(idSucursal).orElse(null);
	}
	@Transactional
	@Override
	public void borrarSucursal(Long id) {
		sucursalDao.deleteById(id);
	}
	

}

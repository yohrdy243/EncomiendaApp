package com.encomienda.app.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encomienda.app.models.dao.ISucursalDao;
import com.encomienda.app.models.entity.Sucursal;

@Service
public class SucursalServicesImpl implements SucursalService {

	@Autowired
	private ISucursalDao sucursalDao;
	
	@Override
	public List<Sucursal> findAll() {
		return (List<Sucursal>)sucursalDao.findAll();
	}

	@Override
	public Sucursal save(Sucursal sucursal) {
		return sucursalDao.save(sucursal);
	}

	@Override
	public Sucursal findById(Long idSucursal) {
		return sucursalDao.findById(idSucursal).orElse(null);
	}

	@Override
	public void deletebyId(Long id) {
		sucursalDao.deleteById(id);
	}

}

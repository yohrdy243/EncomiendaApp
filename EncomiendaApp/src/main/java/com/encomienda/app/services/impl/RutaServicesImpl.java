package com.encomienda.app.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encomienda.app.models.dao.IRutaDao;
import com.encomienda.app.models.entity.Ruta;
import com.encomienda.app.models.entity.Sucursal;
import com.encomienda.app.services.interfaces.IRutaService;

@Service
public class RutaServicesImpl implements IRutaService {

	@Autowired
	private IRutaDao rutaDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Ruta> findAll() {
		return (List<Ruta>)rutaDao.findAll();
	}

	@Transactional
	@Override
	public Ruta save(Ruta ruta) {
		return rutaDao.save(ruta);
	}

	@Transactional(readOnly = true)
	@Override
	public Ruta findById(Long idRuta) {
		return rutaDao.findById(idRuta).orElse(null);
	}
	@Transactional
	@Override
	public void deletebyId(Long id) {
		rutaDao.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Ruta findBySucursalEmisorAndSucursalReceptor(Sucursal sucursalEmisor, Sucursal sucursalReceptor) {
		return rutaDao.findBySucursalEmisorAndSucursalReceptor(sucursalEmisor, sucursalReceptor);
	}

}

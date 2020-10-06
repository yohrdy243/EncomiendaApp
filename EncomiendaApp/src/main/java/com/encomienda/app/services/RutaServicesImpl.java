package com.encomienda.app.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encomienda.app.models.dao.IRutaDao;
import com.encomienda.app.models.entity.Ruta;

@Service
public class RutaServicesImpl implements RutaService {

	@Autowired
	private IRutaDao rutaDao;
	
	@Override
	public List<Ruta> findAll() {
		return (List<Ruta>)rutaDao.findAll();
	}

	@Override
	public Ruta save(Ruta ruta) {
		return rutaDao.save(ruta);
	}

	@Override
	public Ruta findById(Long idRuta) {
		return rutaDao.findById(idRuta).orElse(null);
	}

	@Override
	public void deletebyId(Long id) {
		rutaDao.deleteById(id);
	}

}

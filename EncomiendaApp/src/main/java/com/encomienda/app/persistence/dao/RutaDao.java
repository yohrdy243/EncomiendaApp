package com.encomienda.app.persistence.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encomienda.app.domain.contracts.IRuta;
import com.encomienda.app.domain.entities.Ruta;
import com.encomienda.app.domain.entities.Sucursal;
import com.encomienda.app.persistence.repositories.IRutaRepository;

@Service
public class RutaDao implements IRuta {

	@Autowired
	private IRutaRepository rutaDao;
	
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

package com.encomienda.app.persistence.dao;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encomienda.app.domain.contracts.IPaquete;
import com.encomienda.app.domain.entities.Paquete;
import com.encomienda.app.persistence.repositories.IPaqueteRepository;

@Service
public class PaqueteDao implements IPaquete{

	@Autowired
	private IPaqueteRepository paqueteDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Paquete> obtenerPaquetes() {
		return (List<Paquete>)paqueteDao.findAll();
	}
	
	@Transactional
	@Override
	public Paquete guardarPaquete(Paquete paquete) {
		return paqueteDao.save(paquete);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Paquete buscarPaquete(Long idPaquete) {
		return paqueteDao.findById(idPaquete).orElse(null);
	}
	
	@Transactional
	@Override
	public void borrarPaquete(Long id) {
		paqueteDao.deleteById(id);
		
	}
	@Transactional(readOnly = true)
	@Override
	public Long contarPaquetes() {
		return paqueteDao.count();
	}
	
	@Transactional
	@Override
	public List<Paquete> buscarPaquetesDeCategoria(Long idCategoria) {
		return paqueteDao.findByCategoria_IdCategoria(idCategoria);
	}
	@Transactional
	@Override
	public List<Paquete> buscarPaquetesDeSucursal(Long idSucursal) {
		return paqueteDao.findByOrdenDeEnvio_Ruta_SucursalEmisor_IdSucursal(idSucursal);
	}

	
}

package com.encomienda.app.services.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encomienda.app.models.dao.IPaqueteDao;
import com.encomienda.app.models.entity.Paquete;
import com.encomienda.app.services.interfaces.IPaqueteService;

@Service
public class PaqueteServiceImpl implements IPaqueteService{

	@Autowired
	private IPaqueteDao paqueteDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Paquete> findAll() {
		return (List<Paquete>)paqueteDao.findAll();
	}
	
	@Transactional
	@Override
	public Paquete save(Paquete paquete) {
		return paqueteDao.save(paquete);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Paquete findById(Long idPaquete) {
		return paqueteDao.findById(idPaquete).orElse(null);
	}
	
	@Transactional
	@Override
	public void deletebyId(Long id) {
		paqueteDao.deleteById(id);
		
	}
	@Transactional(readOnly = true)
	@Override
	public Long countRows() {
		return paqueteDao.count();
	}
	
	@Transactional
	@Override
	public List<Paquete> findByCategoria_IdCategoria(Long idCategoria) {
		return paqueteDao.findByCategoria_IdCategoria(idCategoria);
	}
	@Transactional
	@Override
	public List<Paquete> findByOrdenDeEnvio_Ruta_SucursalEmisor_IdSucursal(Long idSucursal) {
		return paqueteDao.findByOrdenDeEnvio_Ruta_SucursalEmisor_IdSucursal(idSucursal);
	}

	
}

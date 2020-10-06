package com.encomienda.app.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encomienda.app.models.dao.IPaqueteDao;
import com.encomienda.app.models.entity.Paquete;

@Service
public class PaqueteServiceImpl implements PaqueteService{

	@Autowired
	private IPaqueteDao paqueteDao;
	
	@Override
	public List<Paquete> findAll() {
		return (List<Paquete>)paqueteDao.findAll();
	}

	@Override
	public Paquete save(Paquete paquete) {
		return paqueteDao.save(paquete);
	}

	@Override
	public Paquete findById(Long idPaquete) {
		return paqueteDao.findById(idPaquete).orElse(null);
	}

	@Override
	public void deletebyId(Long id) {
		paqueteDao.deleteById(id);
	}
}

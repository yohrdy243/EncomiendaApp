package com.encomienda.app.services;

import java.util.List;
import com.encomienda.app.models.entity.Paquete;

public interface PaqueteService {
	
	public List<Paquete> findAll();
	public Paquete save(Paquete paquete);
	public Paquete findById(Long idPaquete);
	public void deletebyId(Long id);
}

package com.encomienda.app.services;

import java.util.List;
import com.encomienda.app.models.entity.Ruta;

public interface RutaService{
	public List<Ruta> findAll();
	public Ruta save(Ruta ruta);
	public Ruta findById(Long idRuta);
	public void deletebyId(Long id);
}

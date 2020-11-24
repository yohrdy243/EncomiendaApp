package com.encomienda.app.services.interfaces;

import java.util.List;
import com.encomienda.app.models.entity.Ruta;
import com.encomienda.app.models.entity.Sucursal;

public interface IRutaService{
	public List<Ruta> findAll();
	public Ruta save(Ruta ruta);
	public Ruta findById(Long idRuta);
	public void deletebyId(Long id);
	public Ruta findBySucursalEmisorAndSucursalReceptor(Sucursal sucursalEmisor,Sucursal sucursalReceptor);
}

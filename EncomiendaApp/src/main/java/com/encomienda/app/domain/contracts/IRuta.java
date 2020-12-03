package com.encomienda.app.domain.contracts;

import java.util.List;

import com.encomienda.app.domain.entities.Ruta;
import com.encomienda.app.domain.entities.Sucursal;

public interface IRuta{
	public List<Ruta> findAll();
	public Ruta save(Ruta ruta);
	public Ruta findById(Long idRuta);
	public void deletebyId(Long id);
	public Ruta findBySucursalEmisorAndSucursalReceptor(Sucursal sucursalEmisor,Sucursal sucursalReceptor);
}

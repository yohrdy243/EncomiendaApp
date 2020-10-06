package com.encomienda.app.services;

import java.util.List;
import com.encomienda.app.models.entity.Sucursal;

public interface SucursalService {
	
	public List<Sucursal> findAll();
	public Sucursal save(Sucursal sucursal);
	public Sucursal findById(Long idSucursal);
	public void deletebyId(Long id);
	

}

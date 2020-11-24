package com.encomienda.app.services.interfaces;

import java.util.List;
import com.encomienda.app.models.entity.Sucursal;

public interface ISucursalService {
	
	public List<Sucursal> findAll();
	public Sucursal save(Sucursal sucursal);
	public Sucursal findById(Long idSucursal);
	public void deletebyId(Long id);
	public Sucursal findByNombre(String nombre);
}

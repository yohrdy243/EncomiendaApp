package com.encomienda.app.domain.contracts;

import java.util.List;

import com.encomienda.app.domain.entities.Sucursal;

public interface ISucursal {
	
	public List<Sucursal> findAll();
	public Sucursal save(Sucursal sucursal);
	public Sucursal findById(Long idSucursal);
	public void deletebyId(Long id);
	public Sucursal findByNombre(String nombre);
}

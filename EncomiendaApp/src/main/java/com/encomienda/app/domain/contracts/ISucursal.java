package com.encomienda.app.domain.contracts;

import java.util.List;

import com.encomienda.app.domain.entities.Sucursal;

public interface ISucursal {
	
	public List<Sucursal> obtenerSucursales();
	public Sucursal guardarSucursal(Sucursal sucursal);
	public Sucursal buscarSucursal(Long idSucursal);
	public void borrarSucursal(Long id);

}

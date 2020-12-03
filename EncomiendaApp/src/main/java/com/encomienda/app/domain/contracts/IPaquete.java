package com.encomienda.app.domain.contracts;

import java.util.List;

import com.encomienda.app.domain.entities.Paquete;

public interface IPaquete {
	
	public List<Paquete> findAll();
	public Paquete save(Paquete paquete);
	public Paquete findById(Long idPaquete);
	public void deletebyId(Long id);
	public Long countRows();
	public List<Paquete> findByCategoria_IdCategoria(Long idCategoria);
	public List<Paquete> findByOrdenDeEnvio_Ruta_SucursalEmisor_IdSucursal(Long idSucursal);
}

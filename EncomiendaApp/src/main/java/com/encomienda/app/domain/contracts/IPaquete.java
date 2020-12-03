package com.encomienda.app.domain.contracts;

import java.util.List;

import com.encomienda.app.domain.entities.Paquete;

public interface IPaquete {
	
	public List<Paquete> obtenerPaquetes();
	public Paquete guardarPaquete(Paquete paquete);
	public Paquete buscarPaquete(Long idPaquete);
	public void borrarPaquete(Long id);
	public Long contarPaquetes();
	public List<Paquete> buscarPaquetesDeCategoria(Long idCategoria);
	public List<Paquete> buscarPaquetesDeSucursal(Long idSucursal);
}

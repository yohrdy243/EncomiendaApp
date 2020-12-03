package com.encomienda.app.domain.contracts;

import java.util.List;

import com.encomienda.app.domain.entities.Ruta;
import com.encomienda.app.domain.entities.Sucursal;

public interface IRuta{
	public List<Ruta> obtenerRutas();
	public Ruta guardarRuta(Ruta ruta);
	public Ruta buscarRuta(Long idRuta);
	public void eliminarRuta(Long id);
	public Ruta buscarRutaPorSucursales(Sucursal sucursalEmisor,Sucursal sucursalReceptor);
}

package com.encomienda.app.domain.contracts;
import java.util.List;

import com.encomienda.app.domain.entities.OrdenDeEnvio;

public interface IOrdenDeEnvio {

	public List<OrdenDeEnvio> obtenerOrdenesDeEnvio();
	public OrdenDeEnvio guardarOrdenDeEnvio(OrdenDeEnvio ordenDeEnvio);
	public OrdenDeEnvio buscarOrdenDeEnvio(Long idOrdenDeEnvio);
	public void borrarOrdenDeEnvio(Long id);
	public Long contarOrdenesDeEnvio();
}

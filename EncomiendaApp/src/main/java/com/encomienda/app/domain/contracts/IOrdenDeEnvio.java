package com.encomienda.app.domain.contracts;
import java.util.List;

import com.encomienda.app.domain.entities.OrdenDeEnvio;

public interface IOrdenDeEnvio {

	public List<OrdenDeEnvio> findAll();
	public OrdenDeEnvio save(OrdenDeEnvio ordenDeEnvio);
	public OrdenDeEnvio findById(Long idOrdenDeEnvio);
	public void deletebyId(Long id);
	public Long countRows();
}

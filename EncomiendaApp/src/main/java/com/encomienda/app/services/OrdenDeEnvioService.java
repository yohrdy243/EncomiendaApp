package com.encomienda.app.services;
import java.util.List;
import com.encomienda.app.models.entity.OrdenDeEnvio;

public interface OrdenDeEnvioService {

	public List<OrdenDeEnvio> findAll();
	public OrdenDeEnvio save(OrdenDeEnvio ordenDeEnvio);
	public OrdenDeEnvio findById(Long idOrdenDeEnvio);
	public void deletebyId(Long id);
}

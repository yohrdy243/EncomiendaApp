package com.encomienda.app.services.interfaces;
import java.util.List;
import com.encomienda.app.models.entity.OrdenDeEnvio;

public interface IOrdenDeEnvioService {

	public List<OrdenDeEnvio> findAll();
	public OrdenDeEnvio save(OrdenDeEnvio ordenDeEnvio);
	public OrdenDeEnvio findById(Long idOrdenDeEnvio);
	public void deletebyId(Long id);
	public Long countRows();
}

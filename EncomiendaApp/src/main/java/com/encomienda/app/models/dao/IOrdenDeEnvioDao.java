package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.encomienda.app.models.entity.OrdenDeEnvio;


@Repository
public interface IOrdenDeEnvioDao extends JpaRepository<OrdenDeEnvio,Long> {
	

}

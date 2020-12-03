package com.encomienda.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encomienda.app.domain.entities.OrdenDeEnvio;


@Repository
public interface IOrdenDeEnvioRepository extends JpaRepository<OrdenDeEnvio,Long> {
	

}

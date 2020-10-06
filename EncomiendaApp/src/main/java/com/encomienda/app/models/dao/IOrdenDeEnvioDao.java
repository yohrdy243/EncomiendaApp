package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encomienda.app.models.entity.OrdenDeEnvio;

public interface IOrdenDeEnvioDao extends JpaRepository<OrdenDeEnvio,Long> {

}

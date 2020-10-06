package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encomienda.app.models.entity.Paquete;

public interface IPaqueteDao extends JpaRepository<Paquete,Long> {

}

package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encomienda.app.models.entity.Ruta;

public interface IRutaDao extends JpaRepository<Ruta,Long> {

}

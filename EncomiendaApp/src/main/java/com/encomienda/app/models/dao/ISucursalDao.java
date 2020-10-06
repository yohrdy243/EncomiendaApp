package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encomienda.app.models.entity.Sucursal;

public interface ISucursalDao extends JpaRepository<Sucursal,Long>{

}

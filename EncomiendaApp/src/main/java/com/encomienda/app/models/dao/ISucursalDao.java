package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encomienda.app.models.entity.Sucursal;

@Repository
public interface ISucursalDao extends JpaRepository<Sucursal,Long>{
	
	public Sucursal findByNombre (String Nombre);

}

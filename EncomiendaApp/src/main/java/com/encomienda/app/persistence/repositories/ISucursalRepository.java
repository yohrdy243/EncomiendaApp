package com.encomienda.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encomienda.app.domain.entities.Sucursal;

@Repository
public interface ISucursalRepository extends JpaRepository<Sucursal,Long>{
	
	public Sucursal findByNombre (String Nombre);

}

package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encomienda.app.models.entity.Ruta;
import com.encomienda.app.models.entity.Sucursal;

@Repository
public interface IRutaDao extends JpaRepository<Ruta,Long> {
	public Ruta findBySucursalEmisorAndSucursalReceptor(Sucursal sucursalEmisor,Sucursal sucursalReceptor);
}

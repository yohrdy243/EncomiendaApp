package com.encomienda.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encomienda.app.domain.entities.Ruta;
import com.encomienda.app.domain.entities.Sucursal;

@Repository
public interface IRutaRepository extends JpaRepository<Ruta,Long> {
	public Ruta findBySucursalEmisorAndSucursalReceptor(Sucursal sucursalEmisor,Sucursal sucursalReceptor);
}

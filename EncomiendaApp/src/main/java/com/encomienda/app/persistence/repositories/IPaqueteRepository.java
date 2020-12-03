package com.encomienda.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encomienda.app.domain.entities.Paquete;

import java.util.List;

@Repository
public interface IPaqueteRepository extends JpaRepository<Paquete,Long> {
	public List<Paquete> findByCategoria_IdCategoria(Long idCategoria);
	public List<Paquete> findByOrdenDeEnvio_Ruta_SucursalEmisor_IdSucursal(Long idSucursal);
}

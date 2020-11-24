package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.encomienda.app.models.entity.Paquete;
import java.util.List;

@Repository
public interface IPaqueteDao extends JpaRepository<Paquete,Long> {
	public List<Paquete> findByCategoria_IdCategoria(Long idCategoria);
	public List<Paquete> findByOrdenDeEnvio_Ruta_SucursalEmisor_IdSucursal(Long idSucursal);
}

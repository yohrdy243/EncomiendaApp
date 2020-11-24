package com.encomienda.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encomienda.app.models.entity.Cliente;

@Repository
public interface IClienteDao extends JpaRepository<Cliente,Long>{
	
	public Cliente findByDni(Long dni);
	public List<Cliente> findByHabilitado(boolean estado);

}

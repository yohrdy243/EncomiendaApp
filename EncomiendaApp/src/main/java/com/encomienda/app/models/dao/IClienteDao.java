package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encomienda.app.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente,Long>{
	

}

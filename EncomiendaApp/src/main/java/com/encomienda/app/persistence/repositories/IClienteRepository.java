package com.encomienda.app.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encomienda.app.domain.entities.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long>{
	public List<Cliente> findByHabilitado(boolean estado);

}

package com.encomienda.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encomienda.app.models.entity.Categoria;

public interface ICategoriaDao extends JpaRepository<Categoria,Long> {

	
}

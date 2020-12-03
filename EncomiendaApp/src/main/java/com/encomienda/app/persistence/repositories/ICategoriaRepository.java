package com.encomienda.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.encomienda.app.domain.entities.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {

	@Query(value ="select c from Categoria c where c.pesoMaximo = (select max(pesoMaximo) from Categoria c1)",name = "Categoria")
	Categoria buscarCategoriaConElPesoMaximoMasAlto();
}

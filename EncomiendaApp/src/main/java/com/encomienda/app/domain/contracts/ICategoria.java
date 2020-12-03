package com.encomienda.app.domain.contracts;
import java.util.List;

import com.encomienda.app.domain.entities.Categoria;

public interface ICategoria {
	
	public List<Categoria> findAll();
	public Categoria save(Categoria categoria);
	public Categoria findById(Long idCategoria);
	public void deletebyId(Long id);
	Categoria buscarCategoriaConElPesoMaximoMasAlto();
	
}

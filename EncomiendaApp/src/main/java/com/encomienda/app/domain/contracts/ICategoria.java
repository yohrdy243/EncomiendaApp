package com.encomienda.app.domain.contracts;
import java.util.List;

import com.encomienda.app.domain.entities.Categoria;

public interface ICategoria {
	
	public List<Categoria> obtenerCategorias();
	public Categoria guardarCategoria(Categoria categoria);
	public Categoria buscarCategoria(Long idCategoria);
	public void borrarCategoria(Long id);
	Categoria buscarCategoriaConElPesoMaximoMasAlto();
	
}

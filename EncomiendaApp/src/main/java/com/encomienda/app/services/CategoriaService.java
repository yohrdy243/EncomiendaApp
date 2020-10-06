package com.encomienda.app.services;
import java.util.List;
import com.encomienda.app.models.entity.Categoria;

public interface CategoriaService {
	
	public List<Categoria> findAll();
	public Categoria save(Categoria categoria);
	public Categoria findById(Long idCategoria);
	public void deletebyId(Long id);
}

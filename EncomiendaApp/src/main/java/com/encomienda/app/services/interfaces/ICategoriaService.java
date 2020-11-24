package com.encomienda.app.services.interfaces;
import java.util.List;
import com.encomienda.app.models.entity.Categoria;

public interface ICategoriaService {
	
	public List<Categoria> findAll();
	public Categoria save(Categoria categoria);
	public Categoria findById(Long idCategoria);
	public void deletebyId(Long id);
	
}

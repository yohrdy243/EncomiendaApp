package com.encomienda.app.persistence.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encomienda.app.domain.contracts.ICategoria;
import com.encomienda.app.domain.entities.Categoria;
import com.encomienda.app.persistence.repositories.ICategoriaRepository;

import org.springframework.transaction.annotation.Transactional;
@Service
public class CategoriaDao implements ICategoria{
	
	@Autowired
	private ICategoriaRepository categoriaDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Categoria> obtenerCategorias() {
		return (List<Categoria>)categoriaDao.findAll();
	}

	@Override
	@Transactional
	public Categoria guardarCategoria(Categoria categoria) {
		return categoriaDao.save(categoria);
	}

	@Transactional(readOnly = true)
	@Override
	public Categoria buscarCategoria(Long idCategoria) {
		return categoriaDao.findById(idCategoria).orElse(null);
	}

	@Transactional
	@Override
	public void borrarCategoria(Long id) {
		categoriaDao.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Categoria buscarCategoriaConElPesoMaximoMasAlto() {
		return categoriaDao.buscarCategoriaConElPesoMaximoMasAlto();
	}

	
	
	
	

}

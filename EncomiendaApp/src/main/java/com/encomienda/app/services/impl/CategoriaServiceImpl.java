package com.encomienda.app.services.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encomienda.app.models.dao.ICategoriaDao;
import com.encomienda.app.models.entity.Categoria;
import com.encomienda.app.services.interfaces.ICategoriaService;

import org.springframework.transaction.annotation.Transactional;
@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>)categoriaDao.findAll();
	}

	@Override
	@Transactional
	public Categoria save(Categoria categoria) {
		return categoriaDao.save(categoria);
	}

	@Transactional(readOnly = true)
	@Override
	public Categoria findById(Long idCategoria) {
		return categoriaDao.findById(idCategoria).orElse(null);
	}

	@Transactional
	@Override
	public void deletebyId(Long id) {
		categoriaDao.deleteById(id);
	}

	
	
	
	

}

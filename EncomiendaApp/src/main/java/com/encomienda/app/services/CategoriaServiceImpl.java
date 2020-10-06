package com.encomienda.app.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encomienda.app.models.dao.ICategoriaDao;
import com.encomienda.app.models.entity.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>)categoriaDao.findAll();
	}

	@Override
	public Categoria save(Categoria categoria) {
		return categoriaDao.save(categoria);
	}

	@Override
	public Categoria findById(Long idCategoria) {
		return categoriaDao.findById(idCategoria).orElse(null);
	}

	@Override
	public void deletebyId(Long id) {
		categoriaDao.deleteById(id);
	}
	

}

package com.encomienda.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.encomienda.app.models.entity.Categoria;
import com.encomienda.app.services.CategoriaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/encomiendas")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaServices;
	
	@GetMapping("/categorias")
	private List<Categoria> listarCategorias(){
		return categoriaServices.findAll();
	}
	
	@GetMapping("categorias/{id}")
	public Categoria buscarCategoriaPorId(@PathVariable Long idCategoria) {
		return categoriaServices.findById(idCategoria);
	}
	
	@PostMapping("/categorias")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria crearCategoria(@RequestBody Categoria categoria) {
		return categoriaServices.save(categoria);
	}
	
	@PutMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria actualizarCategoria(@RequestBody Categoria categoria,@PathVariable Long id) {
		
		Categoria categoriaActual = categoriaServices.findById(id);
		
		float nuevoCosto = categoria.getCosto();
		categoriaActual.setCosto(nuevoCosto);
		
		float nuevoPesoMinimo = categoria.getPesoMinimo();
		categoriaActual.setPesoMinimo(nuevoPesoMinimo);
		
		float nuevoPesoMaximo = categoria.getPesoMaximo();
		categoriaActual.setPesoMaximo(nuevoPesoMaximo);
		
		
		return categoriaServices.save(categoriaActual); 
	}
	
	@DeleteMapping("/categoria/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		categoriaServices.deletebyId(id);
	}
	
	
}
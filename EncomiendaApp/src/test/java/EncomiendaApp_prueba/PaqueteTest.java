package EncomiendaApp_prueba;

import static org.junit.Assert.*;

import org.junit.Test;

import com.encomienda.app.models.entity.Categoria;
import com.encomienda.app.models.entity.Paquete;
/*import com.encomienda.app.services.interfaces.IPaqueteService;*/


public class PaqueteTest {
	
	/*private IPaqueteService paqueteService;*/

	@Test
	public void testValidarEstadoVigente() {
		Paquete paquete = new Paquete();
		paquete.setEstado(true);
		
		boolean resultadoEsperado = true;
		
		assertTrue(paquete.validarEstadoVigente());
		assertEquals(resultadoEsperado, paquete.validarEstadoVigente());
		
	}
	
	
	@Test
	public void testValidarPesoDePaqueteCategoriaA() {
		
		Categoria categoria =  new Categoria();
		categoria.setTipoCategoria('A');
		categoria.setCosto(8);
		categoria.setPesoMaximo(5);
		categoria.setPesoMinimo(0);
		
		
		Paquete paquete = new Paquete();
		paquete.setPeso(3);
		paquete.setCategoria(categoria);
		
		assertTrue(paquete.validarPesoDePaquete());
	}
	
	@Test
	public void testValidarPesoDePaqueteCategoriaB() {
		
		Categoria categoria =  new Categoria();
		categoria.setTipoCategoria('B');
		categoria.setCosto(12);
		categoria.setPesoMaximo(12);
		categoria.setPesoMinimo(6);
		
		Paquete paquete = new Paquete();
		paquete.setPeso(7);
		paquete.setCategoria(categoria);
				
		assertTrue(paquete.validarPesoDePaquete());
		
	}
	
	@Test
	public void testValidarPesoDePaqueteCategoriaC() {
		
		Categoria categoria =  new Categoria();
		categoria.setTipoCategoria('C');
		categoria.setCosto(30);
		categoria.setPesoMaximo(21);
		categoria.setPesoMinimo(13);
		
		Paquete paquete = new Paquete();
		paquete.setPeso(16);
		paquete.setCategoria(categoria);
				
		assertTrue(paquete.validarPesoDePaquete());
		
	}
	
	@Test
	public void testValidarPesoDePaqueteCategoriaD() {
		
		Categoria categoria =  new Categoria();
		categoria.setTipoCategoria('D');
		categoria.setCosto(80);
		categoria.setPesoMaximo(30);
		categoria.setPesoMinimo(22);
		
		
		Paquete paquete = new Paquete();
		paquete.setPeso(26);
		paquete.setCategoria(categoria);
		
		assertTrue(paquete.validarPesoDePaquete());
		
	}
	
	@Test
	public void testValidarPesoDePaqueteCategoriaE() {
		
		Categoria categoria =  new Categoria();
		categoria.setTipoCategoria('E');
		categoria.setCosto(135);
		categoria.setPesoMaximo(150);
		categoria.setPesoMinimo(31);
		
		Paquete paquete = new Paquete();
		paquete.setPeso(130); // SUGERENCIA -- USE A DOUBLE DATATYPE INSTEAD OF A FLOAT DATATYPE
		paquete.setCategoria(categoria);
		
		assertTrue(paquete.validarPesoDePaquete());
		
	}
	
	
	@Test
	public void testGenerarCodigoPaquete() {
		
		Categoria categoria =  new Categoria();
		categoria.setTipoCategoria('D');
		categoria.setCosto(80);
		categoria.setPesoMaximo(30);
		categoria.setPesoMinimo(22);
		
		
		Paquete paquete = new Paquete();
		paquete.setPeso(26);
		paquete.setCategoria(categoria);
		paquete.setCodigo(Integer.toString(1));
		
		String resultadoEsperado = "PD2";

		Long numeroDePaquete = 1l;
		paquete.generarCodigoPaquete(numeroDePaquete);
		
		assertEquals(resultadoEsperado, paquete.getCodigo());
	}
	
}

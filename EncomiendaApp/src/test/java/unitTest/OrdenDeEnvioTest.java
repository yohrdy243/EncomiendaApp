package unitTest;


import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.encomienda.app.domain.entities.Categoria;
import com.encomienda.app.domain.entities.OrdenDeEnvio;
import com.encomienda.app.domain.entities.Paquete;
import com.encomienda.app.domain.entities.Ruta;
import com.encomienda.app.domain.entities.Sucursal;

public class OrdenDeEnvioTest {

	@Test
	public void testCalcularPrecioTotal() {
		
		OrdenDeEnvio ordenDeEnvio = new OrdenDeEnvio();
		
		Categoria categoria =  new Categoria();
		categoria.setTipoCategoria('A');
		categoria.setCosto(8);
		categoria.setPesoMaximo(5);
		categoria.setPesoMinimo(0);
		
		List<Paquete> paquetes = new ArrayList<Paquete>();
		
		Paquete paquete = new Paquete();
		paquete.setPeso(3);
		paquete.setCategoria(categoria);
		
		paquetes.add(paquete);
		
		
		Sucursal sucursal = new Sucursal();
		sucursal.setIdSucursal(1l);
		sucursal.setCodigo("TRUJ");
		sucursal.setNombre("Trujillo");
		sucursal.setDireccion("Av.America");
		
		Sucursal sucursalR = new Sucursal();
		sucursalR.setIdSucursal(1l);
		sucursalR.setCodigo("TRUJ");
		sucursalR.setNombre("Trujillo");
		sucursalR.setDireccion("Av.America");
		
		Ruta ruta = new Ruta();
		ruta.setIdRuta(3l);
		ruta.setPrecio(10);
		ruta.setSucursalEmisor(sucursal);
		ruta.setSucursalReceptor(sucursalR);
		
		ordenDeEnvio.setRuta(ruta);
		ordenDeEnvio.setPaquetes(paquetes);
		
		float resultadoEsperado = 18;
		ordenDeEnvio.calcularPrecioTotal();
		
		assertEquals(resultadoEsperado, ordenDeEnvio.getPrecioTotal(), 0.50);
		
	}
	
	
	@Test
	public void testGenerarCodigoOrden() {
		
		OrdenDeEnvio ordenDeEnvio = new OrdenDeEnvio();
		
		Sucursal sucursal = new Sucursal();
		sucursal.setIdSucursal(1l);
		sucursal.setCodigo("01");
		sucursal.setNombre("Trujillo");
		sucursal.setDireccion("Av.America");
		
		Sucursal sucursalR = new Sucursal();
		sucursalR.setIdSucursal(1l);
		sucursalR.setCodigo("01");
		sucursalR.setNombre("Trujillo");
		sucursalR.setDireccion("Av.America");
		
		Ruta ruta = new Ruta();
		ruta.setIdRuta(1l);
		ruta.setPrecio(10);
		ruta.setSucursalEmisor(sucursal);
		ruta.setSucursalReceptor(sucursalR);
		
		ordenDeEnvio.setRuta(ruta);
		
		Long numeroOden = 1l; // from the database
		ordenDeEnvio.generarCodigoOrden(numeroOden);
		
		
		String resultadoEsperado = "Truj1";
		
		assertEquals(resultadoEsperado, ordenDeEnvio.getCodigo());
	}
	
	@Test
	public void testGenerarClaveOrden() {
		
		OrdenDeEnvio ordenDeEnvio = new OrdenDeEnvio();
		
		Long numeroOden = 1l; // from the database
		ordenDeEnvio.generarClaveOrden(numeroOden);
		
		String expectedValue = ordenDeEnvio.getClave();
		
		assertEquals(expectedValue, ordenDeEnvio.getClave());
		
	}
	
}

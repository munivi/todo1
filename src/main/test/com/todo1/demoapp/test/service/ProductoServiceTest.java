package com.todo1.demoapp.test.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.demoapp.model.Producto;
import com.todo1.demoapp.service.ProductoService;

/**
 * 
 * @author Mustarroz
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductoServiceTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	ProductoService productoService;

	/**
	 * chequea que el producto a buscar sea el que pedi
	 */
	@Test
	public void buscarProductosPorId_Sin_Errores() {
		Producto producto = entityManager
				.persist((Producto) (new Producto(new Long(11), "VASOS LOCOS", new Long(4), new Date(), "Marvel")));
		Producto productoBuscado = productoService.buscarProductosPorId(producto.getId());
		assertEquals(producto.getId(), productoBuscado.getId());
	}

	/**
	 * test que verifica que la cantidad de registros sean los precargados
	 */
	@Test
	public void buscarProductos_Sin_Errores() {
		List<Producto> productoBuscado = productoService.buscarProductos();
		assertEquals(productoBuscado.size(), 10);
	}

	/**
	 * Test que verifica que se agrega un producto exitosamente.
	 */
	@Test
	public void agregarProducto_Sin_Errores() {
		Producto producto = entityManager
				.persist((Producto) (new Producto(new Long(12), "VASOS LOCOS", new Long(4), new Date(), "Marvel")));
		Producto productoBuscado = productoService.buscarProductosPorId(producto.getId());
		assertEquals(producto.getId(), productoBuscado.getId());
		assertEquals(producto.getCodProducto(), productoBuscado.getCodProducto());

	}

	/**
	 * Test que verifica la actualizacion del stock de un producto exitosamente
	 */
	@Test
	public void actualizarStock_Sin_Errores() {
		long nuevoStock = 100;
		Producto producto = entityManager.persist(
				(Producto) (new Producto(new Long(13), "Stock a actualizar", new Long(4), new Date(), "Marvel")));
		producto.setStock(nuevoStock);
		Producto productoStockActualizado = productoService.actualizarStock(producto);
		assertEquals(producto.getId(), productoStockActualizado.getId());
		assertEquals(producto.getStock(), productoStockActualizado.getStock());

	}

}

package com.todo1.demoapp.test.bo;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.todo1.demoapp.KardexApplication;
import com.todo1.demoapp.bo.ProductoBo;
import com.todo1.demoapp.dto.ProductoDTO;
import com.todo1.demoapp.mapper.ProductoMapper;
import com.todo1.demoapp.model.Producto;
import com.todo1.demoapp.service.ProductoService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = KardexApplication.class)
@FixMethodOrder(MethodSorters.DEFAULT)
public class ProductoBoTest {

	private static final long CODIGO_PROD_CAMISETA = 1;
	private static final long CODIGO_PROD_COMIC = 3;
	private static final long STOCK = 20;
	private static final long STOCK_ACTUALIZAR = 10;
	private static final String CAMISETA = "Camiseta";
	private static final String COMIC = "Comic";
	private static final String MARCA_DC = "DC Comics";
	private static final long STOCK_ELIMINAR = 5;

	@Mock
	private ProductoMapper productoMapper;

	@Mock
	private ProductoService productoService;

	@InjectMocks
	private ProductoBo sut;

	/**
	 * test que verifica el guardado de un producto no retorna excepcion
	 */
	@Test
	public void guardarProducto_ConProductoValido_NoRetornaExcepcion() {
		ProductoDTO productoDto = new ProductoDTO(CODIGO_PROD_CAMISETA, CAMISETA, STOCK, new Date(), MARCA_DC);

		Producto producto = new Producto(CODIGO_PROD_CAMISETA, CAMISETA, STOCK, new Date(), MARCA_DC);
		Mockito.when(productoMapper.toModel(productoDto)).thenReturn(producto);

		sut.guardarProducto(productoDto);

		verify(productoMapper, times(1)).toModel(productoDto);
		verify(productoService, times(1)).agregarProducto(producto);
		sut.buscarProductosPorId(productoDto);

	}

	/**
	 * Testea la busqueda de todos los productos sin excepcion
	 */
	@Test
	public void buscarProductos_NoRetornaExcepcion() {
		sut.buscarProductos();
		verify(productoService, times(1)).buscarProductos();
	}

	/**
	 * Test que busca producto por id no retorna excepcion
	 */
	@Test
	public void buscarProductos_Por_Id_NoRetornaExcepcion() {
		ProductoDTO productoDTO = new ProductoDTO(CODIGO_PROD_COMIC, COMIC, STOCK, new Date(), MARCA_DC);
		Producto producto = new Producto(CODIGO_PROD_COMIC, COMIC, STOCK, new Date(), MARCA_DC);

		Mockito.when(productoMapper.toModel(productoDTO)).thenReturn(producto);
		sut.guardarProducto(productoDTO);
		verify(productoService, times(1)).buscarProductosPorId(producto.getId());
		sut.buscarProductosPorId(productoDTO);

	}

	/**
	 * test que actualiza el stock de un producto.
	 */
	@Test
	public void actualizarStockProducto_NoRetornaExcepcion() {
		ProductoDTO productoDTO = new ProductoDTO(CODIGO_PROD_COMIC, COMIC, STOCK, new Date(), MARCA_DC);
		Producto producto = new Producto(CODIGO_PROD_COMIC, COMIC, STOCK_ACTUALIZAR, new Date(), MARCA_DC);

		Mockito.when(productoMapper.toModel(productoDTO)).thenReturn(producto);
		sut.agregarStockProducto(productoDTO);
		verify(productoService, times(1)).buscarProductosPorId(producto.getId());
		sut.buscarProductosPorId(productoDTO);

	}

	/**
	 * test que elimina el stock de un producto.
	 */
	@Test
	public void eliminarStockProducto_NoRetornaExcepcion() {
		ProductoDTO productoDTO = new ProductoDTO(CODIGO_PROD_COMIC, COMIC, STOCK, new Date(), MARCA_DC);
		Producto producto = new Producto(CODIGO_PROD_COMIC, COMIC, STOCK_ELIMINAR, new Date(), MARCA_DC);

		Mockito.when(productoMapper.toModel(productoDTO)).thenReturn(producto);
		sut.agregarStockProducto(productoDTO);
		verify(productoService, times(1)).buscarProductosPorId(producto.getId());
		sut.buscarProductosPorId(productoDTO);

	}

}

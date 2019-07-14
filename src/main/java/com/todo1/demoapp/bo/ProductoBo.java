package com.todo1.demoapp.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.todo1.demoapp.dto.ProductoDTO;
import com.todo1.demoapp.mapper.ProductoMapper;
import com.todo1.demoapp.model.Producto;
import com.todo1.demoapp.service.ProductoService;

@Component
@ComponentScan
public class ProductoBo {
	private static final Logger logger = LogManager.getLogger(ProductoBo.class);

	@Autowired
	ProductoMapper productoMapper;

	@Autowired
	private ProductoService productoService;

	/**
	 * metodo que guarda un producto con su stock
	 * 
	 * @param productoDTO
	 * @return
	 */
	public ProductoDTO guardarProducto(ProductoDTO productoDTO) {
		logger.debug("entrando al metodo guardarProducto");
		productoDTO.setFecha(new Date());
		Producto producto = productoMapper.toModel(productoDTO);
		return productoMapper.toBean(productoService.agregarProducto(producto));
	}

	/**
	 * metodo que busca todo el listado de productos
	 * 
	 * @return una lista de productos con tu stock
	 */
	public List<ProductoDTO> buscarProductos() {
		logger.debug("entrando al metodo buscarProductos");
		List<Producto> productosListEntities = new ArrayList<>();
		productosListEntities.addAll(productoService.buscarProductos());
		List<ProductoDTO> productoDTO = new ArrayList<>();
		productosListEntities.forEach(producto -> productoDTO.add(productoMapper.toBean(producto)));
		return productoDTO;
	}

	/**
	 * metodo que busca un producto por ID.
	 * 
	 * @param productoDTO
	 * @return
	 */
	public ProductoDTO buscarProductosPorId(ProductoDTO productoDTO) {
		logger.debug("entrando al metodo buscarProductosPorId");
		return productoMapper.toBean(productoService.buscarProductosPorId(productoDTO.getId()));
	}

	/**
	 * metodo que agrega el stock del producto enviado desde la interface web.
	 * 
	 * @param productoDto
	 * @return
	 */
	public ProductoDTO agregarStockProducto(ProductoDTO productoDTO) {
		logger.debug("entrando al metodo actualizarStockProducto");
		ProductoDTO anterior = productoMapper.toBean(productoService.buscarProductosPorId(productoDTO.getId()));
		Long suma = (anterior.getStock() + productoDTO.getStock());
		productoDTO.setStock(suma);
		productoDTO.setFecha(new Date());
		return productoMapper.toBean(productoService.actualizarStock(productoMapper.toModel(productoDTO)));
	}

	/**
	 * Metodo que elimina del stock la cantidad enviada por la interface web
	 * si el stock a restar es mayor al stock que hay en el inventario, no deja realizar la operación
	 * @param productoDTO
	 * @return ProductoDTO
	 */
	public ProductoDTO eliminarStockProducto(ProductoDTO productoDTO) {
		logger.debug("entrando al metodo eliminarStockProducto");
		ProductoDTO anterior = productoMapper.toBean(productoService.buscarProductosPorId(productoDTO.getId()));
		Long resta = (anterior.getStock() - productoDTO.getStock());
		if (resta < 0) {
			System.out.println("el stock del producto es menor al que desea sacar");
		} else {
			anterior.setStock(resta);
			anterior.setFecha(new Date());
		}
		productoDTO = productoMapper.toBean(productoService.actualizarStock(productoMapper.toModel(anterior)));
		return productoDTO;

	}

}

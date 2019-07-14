package com.todo1.demoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.demoapp.dao.ProductosRepository;
import com.todo1.demoapp.model.Producto;

/**
 * Implementacion del servicio que se va a comunicar con la persistencia
 * en el repositorio
 * @author Usuario
 *
 */
@Service
@ComponentScan
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	private ProductosRepository productoRepository;
	
	/**
	 * Metodo que persiste en el repositorio un producto
	 * @return Producto
	 */
	@Transactional
	@Override
	public Producto agregarProducto(Producto producto) {
		return (Producto) productoRepository.save(producto);
	}

	/**
	 * Metodo que busca en el repositorio todos los productos
	 * @return List<Producto>
	 */
	@Transactional
	@Override
	public List<Producto> buscarProductos() {
		return (List<Producto>) productoRepository.findAll();
	}

	/**
	 * Metodo que busca en el repositorio un producto por id
	 * @return Producto
	 */
	@Transactional
	@Override
	public Producto buscarProductosPorId(Long id) {
		return  productoRepository.findById(id).get();
	}
	
	/**
	 * Metodo que actualiza en el repositorio el stock de un producto.
	 * @return Producto
	 */
	@Transactional
	@Override
	public Producto actualizarStock(Producto producto) {
		return (Producto) productoRepository.save(producto);
	}
	
	
	
}

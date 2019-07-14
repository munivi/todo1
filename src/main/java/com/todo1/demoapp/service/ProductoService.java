package com.todo1.demoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo1.demoapp.model.Producto;
/**
 * interface para el manejo de los productos
 * @author Mustarroz
 *
 */
@Service
public interface ProductoService {
	
	/**
	 * Agrega 1 producto 
	 * @param producto
	 * @return Producto
	 */
	public Producto agregarProducto(Producto producto);
	
	/**
	 * Busca todos los productos que estan cargados en la base
	 * @return lista de productos 
	 */
	public List<Producto> buscarProductos();
	
	/**
	 * Busca un producto en particular por Id
	 * @param id
	 * @return el producto buscado.
	 */
	public Producto buscarProductosPorId(Long id);
	
	/**
	 * Actualiza el Stock del producto 
	 * @param producto
	 * @return el producto actualizado.
	 */
	public Producto actualizarStock(Producto producto);

}

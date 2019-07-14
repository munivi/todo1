package com.todo1.demoapp.mapper;

import org.springframework.stereotype.Component;

import com.todo1.demoapp.dto.ProductoDTO;
import com.todo1.demoapp.model.Producto;

/**
 * Mapper para el manejo del los objetos DTO y Entity
 * @author Mustarroz
 *
 */
@Component
public class ProductoMapper {
	
	public ProductoMapper() {
	}


	/**
	 * Metodo utilizado para pasar al modelo de DTO para la visualización.
	 * @param productoDTO
	 * @return
	 */
	public ProductoDTO toBean(Producto productoEntity) {
		ProductoDTO producto = new ProductoDTO(productoEntity.getId(),productoEntity.getCodProducto(), productoEntity.getDescripcion(), productoEntity.getStock(),productoEntity.getFechaUltimaActualizacion(), productoEntity.getMarca());
		return producto;
	}

	
	/**
	 * Metodo utilizado para pasar al modelo de persistencia
	 * @param productoDTO
	 * @return
	 */
	public Producto toModel(ProductoDTO productoDTO) {
		Producto producto = new Producto(productoDTO.getId(),productoDTO.getCodProducto(), productoDTO.getDescripcion(), productoDTO.getStock(), productoDTO.getFecha(), productoDTO.getMarca());
		return producto;
	}

}

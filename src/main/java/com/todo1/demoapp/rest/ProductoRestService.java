package com.todo1.demoapp.rest;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.todo1.demoapp.bo.ProductoBo;
import com.todo1.demoapp.dto.ProductoDTO;

/**
 * Controlador Servicio RESTFull para el acceso a los metodos de persistencia , actualizacion y busqueda
 *   
 * @author Usuario
 *
 */
@CrossOrigin
@RestController
public class ProductoRestService {
	/**
	 * log4j2 para logueo
	 */
	private static final Logger logger = LogManager.getLogger(ProductoRestService.class);
	
	/**
	 * Inyect del BO con Spring anottation
	 */
	@Autowired
	private ProductoBo productoBo;

	/**
	 * Metodo que guarda un producto en la base.
	 * @param productoDTO
	 * @return
	 */
    @PostMapping("/v1/api/productos")
	public ResponseEntity<ProductoDTO> addProducto(@RequestBody ProductoDTO productoDTO) {
		logger.debug("Ingrese al metodo addProducto correctamente");
		ProductoDTO productoResponse = productoBo.guardarProducto(productoDTO);
		final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
				.buildAndExpand(productoResponse.getId()).toUri();
		return ResponseEntity.created(uri).body(productoResponse);
	}

	/**
	 * metodo que consulta el listado de productos
	 * @return ResponseEntity con los productos  adentro
	 */
	@GetMapping("/v1/api/productos")
	public ResponseEntity<List<ProductoDTO>> listarProductos() {
		logger.debug("Ingrese al metodo Listar productos correctamente");
		return ResponseEntity.ok(productoBo.buscarProductos());
	}


	/**
	 * metodo que consulta el listado de productos
	 * @return ResponseEntity con los productos  adentro
	 */
	@GetMapping("/v1/api/productos/{id}")
	public ResponseEntity<ProductoDTO> listarProductosById(@PathVariable Long id) {
		logger.debug("Ingrese al metodo Listar productos correctamente");
		return ResponseEntity.ok(productoBo.productosPorId(id));
	}
	
	/**
	 * Metodo para actualizar el stock de un producto
	 * @param productoDTO
	 * @return
	 */
    @PutMapping("/v1/api/productos/agregar")
	public ResponseEntity<ProductoDTO> agregarStock (@RequestBody ProductoDTO productoDTO) {
		logger.debug("Ingrese al metodo agregarStock correctamente");
		return ResponseEntity.ok(productoBo.agregarStockProducto(productoDTO));
	}
	
	/**
	 * Metodo para restar del stock del producto
	 * @param productoDTO
	 * @return
	 */
    @PutMapping("/v1/api/productos/eliminar")
	public ResponseEntity<ProductoDTO> eliminarStock (@RequestBody ProductoDTO productoDTO) {
		logger.debug("Ingrese al metodo agregarStock correctamente");
		return ResponseEntity.ok(productoBo.eliminarStockProducto(productoDTO));
	}

}

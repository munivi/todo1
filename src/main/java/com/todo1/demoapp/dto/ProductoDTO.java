package com.todo1.demoapp.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Objeto Producto DTO para  
 * @author Mustarroz
 *
 */
public class ProductoDTO {
	/**
	 * id autogenerado
	 */
	private Long id;
	/**
	 * Identificación del producto (dato negocio)
	 */
	@JsonProperty
    @NotBlank
	private Long codProducto;
	/**
	 * Detalle del producto
	 */
	@JsonProperty
    @NotBlank
	private String descripcion;
	/**
	 * stock del producto
	 */
	@JsonProperty
    @NotBlank
	private Long stock;
	/**
	 * fecha de ultima modificación del producto
	 */
	private Date fecha;
	/**
	 * Marca del producto
	 */
	private String marca;


	public ProductoDTO() {
	}

	/**
	 * Constructor del objeto ProductoDTO utilizado para modificaciones
	 * @param id
	 * @param codProducto
	 * @param descripcion
	 * @param stock
	 * @param fechaUltimaActualizacion
	 * @param marca
	 */
	public ProductoDTO(Long id, Long codProducto, String descripcion, Long stock, Date fechaUltimaActualizacion, String marca) {
		this.id = id;
		this.codProducto = codProducto;
		this.descripcion = descripcion;
		this.setStock(stock);
		this.setFecha(fechaUltimaActualizacion);
		this.marca = marca;
	}
	
	/**
	 * Constructor del objecto ProductoDTO utilizado para la creación de productos
	 * @param codProducto
	 * @param descripcion
	 * @param stock
	 * @param fechaUltimaActualizacion
	 * @param marca
	 */
	public ProductoDTO( Long codProducto, String descripcion, Long stock, Date fechaUltimaActualizacion, String marca) {
		this.codProducto = codProducto;
		this.descripcion = descripcion;
		this.setStock(stock);
		this.setFecha(fechaUltimaActualizacion);
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Long getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(Long codProducto) {
		this.codProducto = codProducto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}

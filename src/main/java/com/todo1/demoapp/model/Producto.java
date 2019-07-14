package com.todo1.demoapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.todo1.demoapp.dto.ProductoDTO;

/**
 * Entity Producto para la persistencia de datos
 * @author Mustarroz
 *
 */
@Entity(name = "Producto")
public class Producto {
	
	/**
	 * Identificación único de registro
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Identificación del producto (dato negocio)
	 */
	@Column(length = 11)
	private Long codProducto;

	/**
	 * Detalle del producto
	 */
	@Column(length = 255)
	private String descripcion;

	/**
	 * Cantidad acumulada del producto
	 */
	@Column(length = 11)
	private Long stock;

	/**
	 * fecha última actualización
	 */
	@Temporal(TemporalType.DATE)
	private Date fechaUltimaActualizacion;
	
	/**
	 * Marca del producto
	 */
	@Column(length = 255)
	private String marca;


	public Producto( Long id,Long codProducto, String descripcion,Long stock, Date fechaUltimaActualizacion, String marca ) {
		this.id = id;
		this.codProducto = codProducto;
		this.descripcion = descripcion;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		this.stock = stock;
		this.marca = marca;
	}
	
	public Producto(Long codProducto, String descripcion,Long stock, Date fechaUltimaActualizacion, String marca ) {
		this.codProducto = codProducto;
		this.descripcion = descripcion;
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
		this.stock = stock;
		this.marca = marca;
	}

	public Producto() {
		
	}

	public Long getStock() {
		return stock;
	}
	
	public void setStock(Long stock) {
		this.stock = stock;
	}
	
	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}
	
	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(Long codProducto) {
		this.codProducto = codProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
package com.cibertec.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "detalle_compras")
public class DetalleCompras {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalle;
	private Date FechaRegistro;
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
	@ManyToOne
	@JoinColumn(name = "idCompras")
	private Compras compras;
	
	public DetalleCompras() {
	}

	public Integer getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Compras getCompras() {
		return compras;
	}

	public void setCompras(Compras compras) {
		this.compras = compras;
	}
	

	
	
}

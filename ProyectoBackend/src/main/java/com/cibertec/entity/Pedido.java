package com.cibertec.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_detalle")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;
	@Column(name = "fechaPedido")
	private Date fecha;
	@ManyToOne
	@JoinColumn(name = "idDetalle")
	private Compras detalle;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Compras getDetalle() {
		return detalle;
	}
	public void setDetalle(Compras detalle) {
		this.detalle = detalle;
	}
	
	
	
}

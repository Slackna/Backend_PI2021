package com.cibertec.entity;


import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cibertec.security.entity.Rol;



@Entity
@Table(name = "compras")
public class Compras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompras;
	@Column(name = "FechaCompras")
	private Date fecha;
	private double Monto;
	private String Estado;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
    private String NombreProducto;
	
	public Compras() {
	}
	
	
	
	public Integer getIdCompras() {
		return idCompras;
	}
	public void setIdCompras(Integer idCompras) {
		this.idCompras = idCompras;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public double getMonto() {
		return Monto;
	}
	public void setMonto(double monto) {
		Monto = monto;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}



	public String getNombreProducto() {
		return NombreProducto;
	}



	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	

	






	
	
	


}

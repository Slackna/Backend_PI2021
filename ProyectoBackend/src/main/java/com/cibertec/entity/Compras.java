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
	private int Estado;
	private String direccion;
	private String pais;
	private String distrito;
	private String provincia;
	private int codigoPostal;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
    private String NombreProducto;
    private String nota;
	
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
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
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



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getPais() {
		return pais;
	}



	public void setPais(String pais) {
		this.pais = pais;
	}



	public String getDistrito() {
		return distrito;
	}



	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}



	public String getProvincia() {
		return provincia;
	}



	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}



	public int getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	public String getNota() {
		return nota;
	}



	public void setNota(String nota) {
		this.nota = nota;
	}



	

	






	
	
	


}

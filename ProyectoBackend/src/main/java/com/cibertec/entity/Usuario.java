package com.cibertec.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cibertec.security.entity.Rol;



@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idUsuario;
	@NotNull
	@NotBlank
	private String nombreUsuario;
	@NotNull
	@NotBlank
    private String password;
	private String nombre;
	private String paterno;
	private String materno;
	private String dni;
	private String direccion;
	private String celular;
	@Email
	private String email; 
	private String ruc;
	@Column(name = "razon_social")
	private String razonSocial;
	
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
	    inverseJoinColumns = @JoinColumn(name = "rol_id"))
	    private Set<Rol> roles = new HashSet<>();
	 
	public Usuario() {
		
	}
	
	
	
	public Usuario(  @NotNull String nombreUsuario,  @NotNull String password, String nombre, String paterno, String materno, String dni,
			String direccion, String celular,@Email String email, String ruc, String razonSocial) {
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
		this.dni = dni;
		this.direccion = direccion;
		this.celular = celular;
		this.email = email;
		this.ruc = ruc;
		this.razonSocial = razonSocial;
	}


	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}


	 
	
	 

}

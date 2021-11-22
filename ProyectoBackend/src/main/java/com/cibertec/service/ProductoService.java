package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.cibertec.entity.Categoria;
import com.cibertec.entity.Producto;

public interface ProductoService {
	public abstract List<Producto> listaProducto();
	public abstract List<Producto> listaProductoByCat(int  idCategoria);
	public abstract Producto insertaActualizaProducto(Producto obj);
	public abstract Optional<Producto> obtienePorId(int idProducto);
	public abstract List<Producto> listaProductoporUsuario(int  idUsuario);
}

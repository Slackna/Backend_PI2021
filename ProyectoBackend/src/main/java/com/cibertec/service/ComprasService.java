package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Compras;
import com.cibertec.entity.Producto;
import com.cibertec.entity.Usuario;


public interface ComprasService {
	List<Compras> findAll();
	Optional<Compras> findById(Integer id);
	Compras save (Compras compra);
	List<Compras> findByUsuario (Usuario usuario);
	public abstract List<Compras> listaComprasPorUsuario(int  idUsuario);
}

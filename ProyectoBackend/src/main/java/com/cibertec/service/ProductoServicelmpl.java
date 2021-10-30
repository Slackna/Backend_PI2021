package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Producto;
import com.cibertec.repository.ProductoRepository;

@Service
public class ProductoServicelmpl   implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	

	@Override
	public List<Producto> listaProducto() {
		return repository.findAll();
	}

	@Override
	public Producto insertaActualizaProducto(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Producto> obtienePorId(int idProducto) {
		// TODO Auto-generated method stub
		return repository.findById(idProducto);
	}


}

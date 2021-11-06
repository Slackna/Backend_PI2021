package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	@Transactional
	public Producto insertaActualizaProducto(Producto obj, List<MultipartFile> lstFoto) {
		Producto objProducto = null;
		try {
			objProducto=  repository.save(obj);
			for (MultipartFile aux : lstFoto) {
				objProducto  = new Producto();
				objProducto.setImg1(aux.getBytes());
				repository.save(objProducto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objProducto;
	}
	
	@Override
	public Optional<Producto> obtienePorId(int idProducto) {
		// TODO Auto-generated method stub
		return repository.findById(idProducto);
	}


}

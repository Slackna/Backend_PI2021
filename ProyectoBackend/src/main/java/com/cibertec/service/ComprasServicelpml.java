package com.cibertec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Compras;
import com.cibertec.entity.Producto;
import com.cibertec.entity.Usuario;
import com.cibertec.repository.ComprasRepository;




@Service
public class ComprasServicelpml implements ComprasService{

	
	@Autowired
	private ComprasRepository comprasRepository;

	@Override
	public List<Compras> findAll() {
		// TODO Auto-generated method stub
		return comprasRepository.findAll();
	}

	@Override
	public Optional<Compras> findById(Integer id) {
		// TODO Auto-generated method stub
		return comprasRepository.findById(id);
	}

	@Override
	public List<Compras> findByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return comprasRepository.findByUsuario(usuario);
	}

	@Override
	public Compras save(Compras compra) {
		// TODO Auto-generated method stub
		return comprasRepository.save(compra);
	}

	@Override
	public List<Compras> listaComprasPorUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return comprasRepository.ListaporUsuario(idUsuario);
	}

	@Override
	public Compras insertaActualizaDocente(Compras obj) {
		// TODO Auto-generated method stub
		return comprasRepository.save(obj);
	}

	
	

}

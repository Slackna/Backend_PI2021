package com.cibertec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.DetalleCompras;
import com.cibertec.repository.DetalleComprasRepository;



@Service
public class DetalleComprasServicelmpl implements DetalleComprasService{

	
	@Autowired
	private DetalleComprasRepository detalleComprasRepository;
	
	@Override
	public DetalleCompras save(DetalleCompras detalleCompras) {
		// TODO Auto-generated method stub
		return detalleComprasRepository.save(detalleCompras);
	}

}

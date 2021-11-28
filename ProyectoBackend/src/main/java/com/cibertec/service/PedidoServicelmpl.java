package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Pedido;

import com.cibertec.repository.PedidoRepository;

@Service
public class PedidoServicelmpl  implements PedidoService {

	
	@Autowired
	private PedidoRepository pedidoService;
	@Override
	public Pedido save(Pedido pedidoDetalle) {
		return pedidoService.save(pedidoDetalle);
		
	}
	@Override
	public List<Pedido> listaPedidoPorUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return pedidoService.ListapedidoPorUsuario(idUsuario);
	}

}

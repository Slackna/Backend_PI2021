package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Compras;
import com.cibertec.entity.Pedido;


public interface PedidoService {
	Pedido save (Pedido pedidoDetalle);
	public abstract List<Pedido> listaPedidoPorUsuario(int  idUsuario);
}

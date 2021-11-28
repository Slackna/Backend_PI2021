package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Compras;
import com.cibertec.entity.DetalleCompras;
import com.cibertec.entity.Producto;


public interface DetalleComprasService {
	DetalleCompras save (DetalleCompras detalleCompras);
	public abstract List<DetalleCompras> lista(int  idCompras);
}

package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Compras;
import com.cibertec.entity.DetalleCompras;
import com.cibertec.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	@Query("SELECT pro FROM Pedido pro  WHERE pro.usuario.idUsuario=(:idUsuario)")
	List<Pedido> ListapedidoPorUsuario(@Param("idUsuario") int idUsuario);
}

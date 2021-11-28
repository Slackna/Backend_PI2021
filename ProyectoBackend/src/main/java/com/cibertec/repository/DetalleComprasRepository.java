package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Compras;
import com.cibertec.entity.DetalleCompras;

public interface DetalleComprasRepository extends JpaRepository<DetalleCompras, Integer> {
	@Query("SELECT pro FROM DetalleCompras pro  WHERE pro.compras.idCompras=(:idCompras)")
	List<DetalleCompras> ListaporCompra(@Param("idCompras") int idCompras);
	
								 	
}

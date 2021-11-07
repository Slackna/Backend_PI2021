package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Producto;


public interface ProductoRepository  extends JpaRepository<Producto, Integer>  {

	@Query("SELECT pro FROM Producto pro  WHERE pro.categoria.id_categoria=(:id_categoria)")
	List<Producto> findByCat(@Param("id_categoria") int id_categoria);

}

package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cibertec.entity.Compras;
import com.cibertec.entity.Producto;
import com.cibertec.entity.Usuario;


@Repository
public interface ComprasRepository extends JpaRepository<Compras, Integer>{
	List<Compras> findByUsuario (Usuario usuario);
	@Query("SELECT pro FROM Compras pro  WHERE pro.usuario.idUsuario=(:idUsuario)")
	List<Compras> ListaporUsuario(@Param("idUsuario") int idUsuario);

	
}

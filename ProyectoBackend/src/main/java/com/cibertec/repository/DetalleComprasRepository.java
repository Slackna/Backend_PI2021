package com.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.entity.Compras;
import com.cibertec.entity.DetalleCompras;

public interface DetalleComprasRepository extends JpaRepository<DetalleCompras, Integer> {

}

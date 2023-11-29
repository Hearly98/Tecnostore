package com.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnostore.model.Producto;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto, Integer>{
}
 
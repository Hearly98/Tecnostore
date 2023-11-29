package com.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnostore.model.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, String>{

}

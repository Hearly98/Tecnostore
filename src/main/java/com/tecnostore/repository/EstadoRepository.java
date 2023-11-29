package com.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecnostore.model.Estado;

@Repository
public interface EstadoRepository  extends JpaRepository<Estado, String> {

}

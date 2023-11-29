package com.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnostore.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}

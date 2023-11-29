package com.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnostore.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, String> {

}

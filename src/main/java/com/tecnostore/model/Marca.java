package com.tecnostore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "marca")
@Data
public class Marca {
   @Id
   private String idmarca;
   private String nombreMarca;
}

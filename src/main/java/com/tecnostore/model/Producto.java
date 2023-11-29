package com.tecnostore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Producto {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private int id;
   @Column(name = "codigo_producto")
   private String codigoProducto;
   @Column(name = "nombre_producto")
   private String nombreProducto;
   private String descripcion;
   private double precio;
   private int stock;

   @ManyToOne
   @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
   private Categoria categoria;

   @ManyToOne
   @JoinColumn(name = "idmarca", referencedColumnName = "idmarca")
   private Marca marca; 

   @ManyToOne
   @JoinColumn(name = "idestado", referencedColumnName = "idestado")
   private Estado estado;
}

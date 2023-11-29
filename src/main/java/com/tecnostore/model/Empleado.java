package com.tecnostore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_empleados")
@Data
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	private int idEmpleado;

	@Column(name = "nom_empleado")
	private String nomEmpleado;

	@Column(name = "telefono_empleado")
	private String telefonoEmpleado;

	@Column(name = "fecha_contratacion")
	private String fechaContratacion;

	@Column(name = "fecha_terminacion")
	private String fechaTerminacion;

	@Column(name = "salario_empleado")
	private double salarioEmpleado;

	@ManyToOne
	@JoinColumn(name = "id_genero", referencedColumnName = "id_genero")
	private Genero genero;

	@ManyToOne
	@JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
	private Cargo cargo;
}

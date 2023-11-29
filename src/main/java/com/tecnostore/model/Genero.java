package com.tecnostore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_genero")
@Data
public class Genero {
	@Id
	@Column(name = "id_genero")
	private String idGenero;

	@Column(name = "des_genero")
	private String desGenero;
}

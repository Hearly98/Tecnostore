package com.tecnostore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_cargo")
@Data

public class Cargo {
	@Id
	@Column(name = "id_cargo")
	private String idCargo;

	@Column(name = "des_cargo")
	private String desCargo;
}

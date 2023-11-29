package com.tecnostore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "estados")
@Data
public class Estado {
    @Id
    @Column(name = "idestado")
    private String idestado;
    private String nombreEstado;
}

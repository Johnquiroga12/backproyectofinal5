package com.proyecto.parking_cam.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "guardia")
public class Guardia extends Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guardia")
    private Integer id_guardia;
    @Column(name = "jornada")
    private String gornada;
    @Column(name = "id_persona")
    private String id_persona;
}

package com.proyecto.parking_cam.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "registro")
public class Registro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Integer id_registro;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "hora_entrada")
    private String hora_entrada;
    @Column(name = "hora_salida")
    private String hora_salida;
    @Column(name = "observaciones")
    private String observaciones;


    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName ="id_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name="id_bloque",referencedColumnName ="id_bloque")
    private Bloque bloque;
    
    @ManyToOne
    @JoinColumn(name="id_vehiculo",referencedColumnName ="id_vehiculo")
    private Vehiculo vehiculo;
    
    
}

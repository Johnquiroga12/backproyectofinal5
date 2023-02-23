package com.proyecto.parking_cam.modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer id_persona;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "correo")
    private String correo;
    @Column(name = "cargo")
    private String tipo;
    @Column(name = "celular")
    private String celular;
    @Column(name = "n_emergencia")
    private String n_emergencia;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "jornada")
    private String jornada;

    @JsonIgnore
    @OneToOne(mappedBy = "persona")
    private Usuario usuario;
    
   // @JsonIgnore
   // @OneToMany(mappedBy = "persona")
   // private List<Vehiculo> vehiculo;
    
    //@JsonIgnore
   // @OneToMany(mappedBy = "persona")
    //private List<Registro> registro;
}

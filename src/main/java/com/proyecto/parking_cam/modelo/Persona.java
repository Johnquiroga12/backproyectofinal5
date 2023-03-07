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
    private String cargo;
    @Column(name = "celular")
    private String celular;
    @Column(name = "n_emergencia")
    private String n_emergencia;
    @Column(name = "carrera")
    private String carrera;
    @Column(name = "jornada")
    private String jornada;
    @Column(name = "estado")
    private String estado;
 
    
    public Persona(){
        
    }

    public Persona(Integer id){
        
        super();
        this.id_persona = id;
    }
    
    public Persona(Integer id_persona, String nombre, String apellido, String cedula, String correo, String cargo, String celular, String n_emergencia, String carrera, String jornada, String estado, Usuario usuario) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.cargo = cargo;
        this.celular = celular;
        this.n_emergencia = n_emergencia;
        this.carrera = carrera;
        this.jornada = jornada;
        this.estado = estado;
    }


    
   }

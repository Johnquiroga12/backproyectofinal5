package com.proyecto.parking_cam.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id_usuario;
    //@Column(name = "username")
    //private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "rol")
    private String rol;
   // @Column(name = "instruccion")
   // private String instruccion;
    @OneToOne
    @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
    private Persona persona;
    
   // @JsonIgnore
    //@OneToMany(mappedBy = "usuario")
    //private List<Registro> registro;
}

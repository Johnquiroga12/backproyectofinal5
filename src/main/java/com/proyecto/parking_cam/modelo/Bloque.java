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
@Table(name = "bloque")
public class Bloque implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bloque")
    private Integer id_bloque;
    @Column(name = "plazas")
    private String plazas;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "bloque")
    private List<Registro> registro;
    

    

}

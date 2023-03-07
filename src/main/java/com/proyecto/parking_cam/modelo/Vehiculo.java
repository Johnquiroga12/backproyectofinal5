package com.proyecto.parking_cam.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Integer id_vehiculo;
    @Column(name = "ticket")
    private Integer ticket;
    @Column(name = "placa")
    private String placa;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "color")
    private String color;
    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    
        public Vehiculo(){
        
    }
        
        public Vehiculo(Integer id){
        
            super();
            this.id_vehiculo = id;
    }

    public Vehiculo(Integer id_vehiculo, Integer ticket, String placa, String marca, String modelo, String color, String estado, Persona persona) {
        this.id_vehiculo = id_vehiculo;
        this.ticket = ticket;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.estado = estado;
        this.persona = persona;
    }

       
}

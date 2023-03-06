package com.proyecto.parking_cam.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @Column(name = "id_vehiculo")
    private Integer id_vehiculo;
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

    public Vehiculo(Integer id_vehiculo, String placa, String marca, String modelo, String color, String estado, Persona persona) {
        this.id_vehiculo = id_vehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.estado = estado;
        this.persona = persona;
    }
        
        
        
    public Integer getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Integer id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

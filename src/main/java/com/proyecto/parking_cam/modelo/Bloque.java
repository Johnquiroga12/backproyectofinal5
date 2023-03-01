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
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "plazas")
    private String plazas;


        public Bloque(){
        
    }
        
        public Bloque(Integer id){
        
            this.id_bloque = id;
    }

    public Bloque(Integer id_bloque, String nombre, String plazas) {
        this.id_bloque = id_bloque;
        this.nombre = nombre;
        this.plazas = plazas;
    }
       
        
        
    public Integer getId_bloque() {
        return id_bloque;
    }

    public void setId_bloque(Integer id_bloque) {
        this.id_bloque = id_bloque;
    }

    public String getPlazas() {
        return plazas;
    }

    public void setPlazas(String plazas) {
        this.plazas = plazas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}

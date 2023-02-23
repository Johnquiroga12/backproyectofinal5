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
@Table(name = "vehiculo")
public class Vehiculo implements Serializable{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
	 private Persona persona;
	 
	 
	 @JsonIgnore
	 @OneToMany(mappedBy = "vehiculo")
	 private List<Registro> registro;
	 
	 
}

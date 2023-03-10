package com.proyecto.parking_cam.modelo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "registro")
public class Registro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro")
	private Integer id_registro;
	@Column(name = "condicion")
	private String condicion;
	@Column(name = "fecha")
	private String fecha;
	@Column(name = "hora_entrada")
	private String hora_entrada;
	@Column(name = "hora_salida")
	private String hora_salida;
	@Column(name = "observaciones")
	private String observaciones;
	@Column(name = "estado")
	private String estado;

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_bloque", referencedColumnName = "id_bloque")
	private Bloque bloque;

	@ManyToOne
	@JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
	private Vehiculo vehiculo;

	public Registro() {

	}

	public Registro(Integer id) {
		super();
		this.id_registro = id;
	}

	public Registro(Integer id_registro, String condicion, String fecha, String hora_entrada, String hora_salida,
			String observaciones, String estado, Usuario usuario, Bloque bloque, Vehiculo vehiculo) {
		this.id_registro = id_registro;
		this.condicion = condicion;
		this.fecha = fecha;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.observaciones = observaciones;
		this.estado = estado;
		this.usuario = usuario;
		this.bloque = bloque;
		this.vehiculo = vehiculo;
	}

	public Integer getId_registro() {
		return id_registro;
	}

	public void setId_registro(Integer id_registro) {
		this.id_registro = id_registro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Bloque getBloque() {
		return bloque;
	}

	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

}

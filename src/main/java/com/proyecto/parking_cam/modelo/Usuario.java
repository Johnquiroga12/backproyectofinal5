package com.proyecto.parking_cam.modelo;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id_usuario;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "rol")
	private String rol;
	@Column(name = "estado")
	private String estado;

	@Column(name = "foto", columnDefinition = "LONGBLOB")
	private String foto;
	
	//@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
	private Persona persona;

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Usuario() {

	}

	public Usuario(Integer id) {

		super();
		this.id_usuario = id;

	}

	public Usuario(Integer id_usuario, String username, String password, String rol, String estado, Persona persona) {
		this.id_usuario = id_usuario;
		this.username = username;
		this.password = password;
		this.rol = rol;
		this.estado = estado;
		this.persona = persona;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}

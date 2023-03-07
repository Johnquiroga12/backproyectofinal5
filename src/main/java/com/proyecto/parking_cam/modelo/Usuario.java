package com.proyecto.parking_cam.modelo;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
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

    @OneToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

        public Usuario(){
        
    }
        
        public Usuario(Integer id){
            
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
        
        
       
    

}

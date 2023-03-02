package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    
    @Query(value = "SELECT * FROM usuario WHERE usuario.username = :username AND usuario.password = :password", nativeQuery = true)
    public Usuario buscarRol (@Param("username") String username, @Param("password") String password);
    
}
package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsernameAndPassword(String username, String password);
    Usuario findByUsername(String username);
}
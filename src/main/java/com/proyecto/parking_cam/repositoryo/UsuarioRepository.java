package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.modelo.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    @Query(value ="SELECT* FROM usuario WHERE username =:filtro AND password=:filter",nativeQuery = true)
public Usuario search(@Param("filtro") String filtro, @Param("filter") String filter);

    public Usuario findUsuarioByPersona(Persona p);

    List<Usuario> findAllByEstado(String a);

    //Metodo para el login
    public Usuario findByUsernameAndPassword(String ci, String pas);
}
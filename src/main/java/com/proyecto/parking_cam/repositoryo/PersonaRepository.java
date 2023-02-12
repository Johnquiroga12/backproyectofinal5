package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
public Persona findByCorreoAndContrasenia( String correo , String contra);
}

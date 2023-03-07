package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.modelo.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {


    public Persona findByCedulaAndEstado(String cedula, String estado);

    List<Persona> findAllByEstado(String a);
}

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

    @Query(value = "SELECT * FROM persona v WHERE v.estado = 'A'", nativeQuery = true)
    List<Persona> listarPersonasActivos();

    public Persona findByCedulaAndEstado(String cedula, String estado);

    List<Persona> findAllByEstado(String a);
}

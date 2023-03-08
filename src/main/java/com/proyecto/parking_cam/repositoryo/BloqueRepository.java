package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.modelo.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueRepository extends JpaRepository<Bloque, Integer> {

<<<<<<< Updated upstream
    List<Bloque> findAllByEstado(String a);
=======
    @Query(value = "SELECT * FROM bloque v WHERE v.estado = 'A'", nativeQuery = true)
    List<Bloque> listarBloquesActivos();

    List<Bloque> findAllByEstado(String a);

>>>>>>> Stashed changes
}

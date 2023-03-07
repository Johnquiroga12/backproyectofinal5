package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Registro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {

    List<Registro> findAllByEstado(String a);
}

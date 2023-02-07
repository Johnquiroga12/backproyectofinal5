package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Guardia;
import com.proyecto.parking_cam.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuardiaRepository extends JpaRepository<Guardia, Integer> {
}

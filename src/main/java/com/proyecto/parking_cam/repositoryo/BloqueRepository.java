package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.modelo.Guardia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueRepository extends JpaRepository<Bloque, Integer> {
}

package com.proyecto.parking_cam.repositoryo;
import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.modelo.Vehiculo;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {


    public Persona findByCedulaAndEstado(String cedula, String estado);

    List<Persona> findAllByEstado(String a);
    
    @Query(value = "SELECT COUNT(DISTINCT p.id_persona) AS Usuarios, " +
            "(SELECT COUNT(*) FROM persona WHERE estado = 'A' AND cargo = 'Estudiante') AS Estudiantes, " +
            "(SELECT COUNT(*) FROM persona WHERE estado = 'A' AND cargo = 'Docente') AS Docentes, " +
            "COUNT(DISTINCT v.id_vehiculo) AS Vehiculos, " +
            "COUNT(DISTINCT r.id_registro) AS Registros " +
            "FROM persona p " +
            "LEFT JOIN vehiculo v ON p.id_persona = v.id_persona " +
            "LEFT JOIN registro r ON v.id_vehiculo = r.id_vehiculo", nativeQuery = true)
    Map<String, Object> getAllByNumeros();
}

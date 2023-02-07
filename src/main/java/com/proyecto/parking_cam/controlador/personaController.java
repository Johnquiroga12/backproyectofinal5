package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.servicio.personaService;
import com.proyecto.parking_cam.servicio.registroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class personaController {
    @Autowired
    private personaService ser;

    @GetMapping("/do/listar")
    public ResponseEntity<List<Persona>> getAll() {
        try {
            return new ResponseEntity<>(ser.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/do/search/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(ser.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/do/crear")
    public ResponseEntity<Persona> createReproducion(@RequestBody Persona persona){
        try {
            return new ResponseEntity<>(ser.save(persona), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/do/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
            ser.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al docente");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/do/update/{id}")
    public ResponseEntity<Persona> updateClient(@RequestBody Persona empl, @PathVariable("id") Integer id){
        Persona ca =ser.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setNombre(empl.getNombre());
                ca.setApellido(empl.getApellido());
                ca.setCorreo(empl.getCorreo());
                ca.setCedula(empl.getCedula());
                return new ResponseEntity<>(ser.save(empl), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}

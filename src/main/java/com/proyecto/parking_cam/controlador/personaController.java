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
@RequestMapping("/apiox")
public class personaController {
    @Autowired
    private personaService perser;

    @GetMapping("/per/listar")
    public ResponseEntity<List<Persona>> getAll() {
        try {
            return new ResponseEntity<>(perser.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/per/{user}/{contra}")
    public ResponseEntity<?> login(@PathVariable("user") String  user,@PathVariable("contra") String  contra){
        try {
            return new ResponseEntity<>(perser.findByCorreoAndContrasenia(user, contra), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/per/search/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(perser.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/per/crear")
    public ResponseEntity<Persona> createReproducion(@RequestBody Persona persona){
        try {
            return new ResponseEntity<>(perser.save(persona), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/per/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
            perser.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar a la persona");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/per/update/{id}")
    public ResponseEntity<Persona> updateClient(@RequestBody Persona empl, @PathVariable("id") Integer id){
        Persona ca =perser.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setNombre(empl.getNombre());
                ca.setApellido(empl.getApellido());
                ca.setCorreo(empl.getCorreo());
                ca.setCedula(empl.getCedula());
                ca.setTipo(empl.getTipo());

                return new ResponseEntity<>(perser.save(empl), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}

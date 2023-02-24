package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Registro;
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
public class RegController {
    @Autowired
    private registroService registroService;

    @GetMapping("/registros/listar")
    public ResponseEntity<List<Registro>> getAll() {
        try {
            return new ResponseEntity<>(registroService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/registros/search/{id}")
    public ResponseEntity<Registro> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(registroService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/registros/crear")
    public ResponseEntity<Registro> createReproducion(@RequestBody Registro registro){
        try {
            return new ResponseEntity<>(registroService.save(registro), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/registros/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
        	registroService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al docente");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/registros/update/{id}")
    public ResponseEntity<Registro> updateClient(@RequestBody Registro reg, @PathVariable("id") Integer id){
        Registro ca =registroService.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setHora_salida(reg.getHora_salida());
                ca.setObservaciones(reg.getObservaciones());
                return new ResponseEntity<>(registroService.save(reg), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}

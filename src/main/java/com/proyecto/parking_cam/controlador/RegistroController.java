package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.servicio.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegistroController {
    @Autowired
    private RegistroService registroService;
    
    
    @GetMapping("/registro/listar")
    public ResponseEntity<List<Registro>> obtenerLista() {
        try {
            return new ResponseEntity<>(registroService.listarRegistroActivos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/registro/list")
    public ResponseEntity<List<Registro>> list() {
        try {
            return new ResponseEntity<>(registroService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/registro/search/{id}")
    public ResponseEntity<Registro> search(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(registroService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/registro/create")
    public ResponseEntity<Registro> create(@RequestBody Registro registro){
        try {
            return new ResponseEntity<>(registroService.save(registro), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/registro/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
        	registroService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el Registro");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/registro/update/{id}")
    public ResponseEntity<Registro> update(@RequestBody Registro reg, @PathVariable("id") Integer id){
        Registro ca =registroService.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setEstado(reg.getEstado());
                return new ResponseEntity<>(registroService.save(reg), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }
}

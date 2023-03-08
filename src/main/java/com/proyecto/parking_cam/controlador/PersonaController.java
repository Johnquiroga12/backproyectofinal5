package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonaController {
	
    @Autowired
    private PersonaService perServ;

    
    @GetMapping("/persona/listar")
    public ResponseEntity<List<Persona>> obtenerLista() {
        try {
            return new ResponseEntity<>(perServ.findAllByEstado("A"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    
    @GetMapping("/persona/list")
    public ResponseEntity<List<Persona>> list() {
        try {
            return new ResponseEntity<>(perServ.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/persona/search/{id}")
    public ResponseEntity<Persona> search(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(perServ.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/persona/create")
    public ResponseEntity<Persona> create(@RequestBody Persona persona){
        try {
            return new ResponseEntity<>(perServ.save(persona), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/persona/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
        	perServ.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el Registro");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/persona/update/{id}")
    public ResponseEntity<Persona> update(@RequestBody Persona perRb, @PathVariable("id") Integer id){
        Persona per = perServ.findById(id);

        if(per == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
            	per.setEstado(perRb.getEstado());

                return new ResponseEntity<>(perServ.save(perRb), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    //Metodos para la verificasion de la cedula para el cambio de la contraseña..
    @GetMapping("/persona/search/cedula/update/{cedula}")
    public ResponseEntity<Persona> searchCedulaChangePassword(@PathVariable("cedula") String cedula){
        try {
            Persona p = perServ.findByCedulaAndEstado(cedula, "A");
            if(p != null){
                return new ResponseEntity<>(p, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persona/resumen/data")
    public ResponseEntity<Map<String, Object>> obtenerResumen() {
        try {
            Map<String, Object> resumen = perServ.getAllByNumeros();
            return new ResponseEntity<>(resumen, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

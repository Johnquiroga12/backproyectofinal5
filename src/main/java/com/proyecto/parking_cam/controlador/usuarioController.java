package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Usuario;
import com.proyecto.parking_cam.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiss")
public class usuarioController {
    @Autowired
    private UsuarioService ususer;

    @GetMapping("/user/list")
    public ResponseEntity<List<Usuario>> getAll() {
        try {
            return new ResponseEntity<>(ususer.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @RequestMapping(value = "/usu/{username}/{password}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Usuario login(@PathVariable String username, @PathVariable String password){
        return ususer.login(username, password);
    }
    @GetMapping("porUsername/{username}")
    @ResponseBody
    public boolean porUsername(@PathVariable String username){
        return ususer.porUsername(username);
    }
    @GetMapping("/usu/search/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(ususer.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/user/create")
    public ResponseEntity<Usuario> createReproducion(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity<>(ususer.save(usuario), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
            ususer.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al USUARIO");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<Usuario> updateClient(@RequestBody Usuario empl, @PathVariable("id") Integer id){
        Usuario ca =ususer.findById(id);
        if(ca == null){
            ca.setPassword(empl.getPassword());
            ca.setRol(empl.getRol());
            ca.setInstruccion(empl.getInstruccion());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setRol(empl.getRol());
                ca.setInstruccion(empl.getInstruccion());
                return new ResponseEntity<>(ususer.save(empl), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}

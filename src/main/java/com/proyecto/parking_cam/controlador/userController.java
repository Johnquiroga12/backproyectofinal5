package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Usuario;
import com.proyecto.parking_cam.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class userController {
    @Autowired
    UsuarioService usuarioService;


    @GetMapping("/listar")
    public ResponseEntity< List<Usuario>> obtenerLista() {
        return new ResponseEntity<>(usuarioService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario us){
        return new ResponseEntity<>(usuarioService.save(us), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Integer id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario us) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                usuario.setId_usuario(us.getId_usuario());
                usuario.setPassword(us.getPassword());
                return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
}

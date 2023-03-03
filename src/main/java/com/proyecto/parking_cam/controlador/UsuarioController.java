package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Usuario;
import com.proyecto.parking_cam.repositoryo.UsuarioRepository;
import com.proyecto.parking_cam.servicio.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuServ;
    
    @Autowired
    UsuarioRepository rU;


    @PostMapping("/singin")
    public Usuario IniciarSesion(@RequestBody Usuario usuario) throws Exception{
        
        try{
            
            Usuario usr = rU.buscarRol(usuario.getUsername(), usuario.getPassword());
            return usr;
        }catch(Exception e){
            
            System.out.println(e.toString());
            return null;
            
        }
    }
    
    @GetMapping("/usuario/listar")
    public ResponseEntity<List<Usuario>> obtenerLista() {
        try {
            return new ResponseEntity<>(usuServ.listarUsuariosActivos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    
    @GetMapping("/usuario/list")
    public ResponseEntity<List<Usuario>> list() {
        try {
            return new ResponseEntity<>(usuServ.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @GetMapping("/usuario/search/{id}")
    public ResponseEntity<Usuario> search(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(usuServ.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/usuario/searchname")
    public ResponseEntity<?> searchname(@RequestParam String filtro,@RequestParam String filter){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuServ.search(filtro, filter));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }

    @PostMapping("/usuario/create")
    public ResponseEntity<Usuario> createReproducion(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity<>(usuServ.save(usuario), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/usuario/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
        	usuServ.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el Registro");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/usuario/update/{id}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuRb, @PathVariable("id") Integer id){
    	Usuario usu = usuServ.findById(id);

        if(usu == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
            	usu.setEstado(usuRb.getEstado());

                return new ResponseEntity<>(usuServ.save(usuRb), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}

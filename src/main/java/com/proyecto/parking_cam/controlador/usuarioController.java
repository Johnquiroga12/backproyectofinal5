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
@RequestMapping("/apis")
public class usuarioController {


}

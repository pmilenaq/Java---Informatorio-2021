package com.api.emprender.controller;


import com.api.emprender.entity.Usuario;
import com.api.emprender.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.crear(usuario), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}/eliminar")
    public Usuario eliminarUsuario(@PathVariable("id") Long id, Usuario usuario) {
        return this.usuarioService.eliminar(usuario, id);
    }
    @PutMapping(value = "/{id}")
    public Usuario modificarUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario) {
        return this.usuarioService.modificar(usuario, id);
    }
    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios(@RequestParam(name = "fecha", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate fechaCreacion, @RequestParam(name = "ciudad", required = false) String ciudad) {
        return new ResponseEntity<>(usuarioService.todosLosUsuarios(fechaCreacion, ciudad), HttpStatus.OK);
    }

}


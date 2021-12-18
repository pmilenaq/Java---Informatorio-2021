package com.api.emprender.controller;

import com.api.emprender.entity.Evento;
import com.api.emprender.repository.EventoRepository;
import com.api.emprender.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/eventos")
public class EventoController {

    private final EventoService eventoService;
    private final EventoRepository eventoRepository;

    @Autowired
    public EventoController(EventoService eventoService, EventoRepository eventoRepository) {
        this.eventoService = eventoService;
        this.eventoRepository = eventoRepository;
    }

    @PostMapping
    public ResponseEntity<?> crearEvento(@Valid @RequestBody Evento evento) {
        return new ResponseEntity<>(eventoService.crear(evento), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}/eliminar")
    public Evento eliminarEvento(@PathVariable("id") Long id, Evento evento) {
        return this.eventoService.eliminar(evento, id);
    }
    @PutMapping(value = "/{id}/actualizar-estado")
    public void actualizarEvento() {
        this.eventoService.actualizarFecha();
    }
    @GetMapping(value = "/{id}/ranking")
    public ResponseEntity<?> rankingDelEvento(@PathVariable("id") Long id) {
        return new ResponseEntity<>(eventoService.rankear(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> obtenerTodos() {
        return new ResponseEntity<>(eventoService.obtenerTodos() ,HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
    public Evento modificar(@PathVariable("id") Long id, @Valid @RequestBody Evento evento) {
        return this.eventoService.modificar(evento, id);
    }

}

package com.api.emprender.service;

import com.api.emprender.DTO.EventoDTO;
import com.api.emprender.entity.Emprendimiento;
import com.api.emprender.entity.Evento;
import com.api.emprender.entity.EventoEstado;
import com.api.emprender.repository.EmprendimientoRepository;
import com.api.emprender.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Configuration
@EnableScheduling
public class EventoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final EventoRepository eventoRepository;

    @Autowired
    public EventoService(EmprendimientoRepository emprendimientoRepository, EventoRepository eventoRepository){
        this.emprendimientoRepository = emprendimientoRepository;
        this.eventoRepository = eventoRepository;
    }

    public Evento crear(Evento evento){
        return eventoRepository.save(evento);
    }

    //buscar por id evento
    public Optional<Evento> buscarEventoId(Long id){
        return eventoRepository.findAllById(id);
    }

    //Borrar evento
    public Evento eliminar(Evento evento, Long id){
        Evento eventoEliminado = eventoRepository.getById(id);
        eventoEliminado.setActivo(false);
        return eventoRepository.save(eventoEliminado);
    }
    //mostrar todos los eventos
    public List<Evento> obtenerTodos(){ return eventoRepository.findAll(); };

    //modificar estado evento
    public void actualizarStatus(Evento evento, LocalDate ahora){
        if (evento.getFechaFinalizacion().isAfter(ahora)){
            evento.setEstado(EventoEstado.EN_CURSO);
        }
        if (evento.getFechaFinalizacion().isBefore(ahora)){
            evento.setEstado(EventoEstado.FINALIZADO);
        }
    }

    //modificar fecha evento
    public void actualizarFecha(){
        List<Evento> eventos = eventoRepository.findAll();
        LocalDate ahora = LocalDate.now();
        eventos.stream().forEach(evento -> actualizarStatus(evento, ahora));
        eventoRepository.saveAll(eventos);
        System.out.println("Se actualizó el evento");
    }

    //modificar parametros en evento
    public Evento modificar(Evento evento, Long id) {
        Evento eventoNuevo = eventoRepository.getById(id);

        if (!evento.getNombre().trim().isEmpty()) {
            eventoNuevo.setNombre(evento.getNombre()); }

        if (!evento.getDetalles().trim().isEmpty()) {
            eventoNuevo.setDetalles(evento.getDetalles()); }

        if (evento.getPremio() != null && evento.getPremio() > 0) {
            eventoNuevo.setPremio(evento.getPremio()); }

        if (!evento.getActivo()) {
            eventoNuevo.setActivo(false); }

        if (evento.getEstado() != null) {
            eventoNuevo.setEstado(evento.getEstado());
        }

        return eventoRepository.save(eventoNuevo);
    }

    //Registro de emprendimiento en evento
    public Emprendimiento registrar(Long emprendimientoId, Long eventoId, EventoDTO eventoDTO){
        Emprendimiento emprendimientoRegistrado = emprendimientoRepository.getById(emprendimientoId);
        Evento eventoRegistrado = eventoRepository.getById(eventoId);
        if (eventoRegistrado.getEstado() == EventoEstado.ABIERTO) { emprendimientoRegistrado.agregarEvento(eventoRegistrado);
            System.out.println("La Suscripcion se realizo con exito");
        } else if (eventoRegistrado.getEstado() == EventoEstado.EN_CURSO) {
            System.out.println("no es posible realizar la subscripcion: el evento ya se encuentra en curso");
        } else { System.out.println("El evento ha finalizado."); }
        return emprendimientoRepository.save(emprendimientoRegistrado);
    }

    //ranking eventos
    public Optional<Evento> rankear(Long id) {
        return eventoRepository.findById(id);
    }

}

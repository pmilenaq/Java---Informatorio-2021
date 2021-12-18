package com.api.emprender.service;

import com.api.emprender.entity.Emprendimiento;
import com.api.emprender.entity.Tags;
import com.api.emprender.entity.Usuario;
import com.api.emprender.repository.EmprendimientoRepository;
import com.api.emprender.repository.TagRepository;
import com.api.emprender.repository.UsuarioRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class EmprendimientoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final UsuarioRepositoy usuarioRepository;
    private final TagRepository tagRepository;

    @Autowired
    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository,
                                 UsuarioRepositoy usuarioRepository,
                                 TagRepository tagRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
        this.usuarioRepository = usuarioRepository;
        this.tagRepository = tagRepository;
    }

    public Emprendimiento crear(Emprendimiento emprendimiento, Long usuarioId) {
        Usuario usuario = usuarioRepository.getById(usuarioId);
        emprendimiento.setOwner(usuario);
        return emprendimientoRepository.save(emprendimiento);
    }
    public Emprendimiento eliminar(Long id, Emprendimiento emprendimiento) {
        Emprendimiento emprendimientoEliminado = emprendimientoRepository.getById(id);
        emprendimientoEliminado.setActivo(false);
        return emprendimientoRepository.save(emprendimientoEliminado);
    }
    public Emprendimiento modificar(Emprendimiento emprendimiento, Long id) {
        Emprendimiento emprendimientoModificado = emprendimientoRepository.getById(id);

        if (!emprendimiento.getNombre().trim().isEmpty()) {
            emprendimientoModificado.setNombre(emprendimiento.getNombre()); }

        if (!emprendimiento.getDescripcion().trim().isEmpty()) {
            emprendimientoModificado.setDescripcion(emprendimiento.getDescripcion()); }

        if (!emprendimiento.getContenido().trim().isEmpty()) {
            emprendimientoModificado.setContenido(emprendimiento.getContenido()); }

        if (emprendimiento.getObjetivo() != null && emprendimiento.getObjetivo() > 0) {
            emprendimientoModificado.setObjetivo(emprendimiento.getObjetivo()); }

        if (!emprendimiento.getPublicado()) {
            emprendimientoModificado.setPublicado(false); }

        if (emprendimiento.getPublicado()) {
            emprendimientoModificado.setPublicado(true); }

        if (emprendimiento.getUrl() != null) {
            emprendimientoModificado.setUrl(emprendimiento.getUrl()); }

        if (emprendimiento.getTags() != null) {
            emprendimientoModificado.setTags(emprendimiento.getTags()); }

        return emprendimientoRepository.save(emprendimientoModificado);
    }

    public List<Emprendimiento> obtenerPorTag(String nombre){
        return emprendimientoRepository.findByTags_nombre(nombre);
    }

    public List<Emprendimiento> obtenerTodos(String nombre) {
        if (nombre != null) { Tags tag = tagRepository.findByNombre(nombre);
            return tag.getEmprendimientos();
        } else { return emprendimientoRepository.findAll(); }
    }

    public Stream<Emprendimiento> obtenerNoPublicados() {
        return emprendimientoRepository.findAll().stream().filter(Predicate.not(Emprendimiento::getPublicado));
    }

}

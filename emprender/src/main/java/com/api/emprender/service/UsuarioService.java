package com.api.emprender.service;

import com.api.emprender.entity.Usuario;
import com.api.emprender.repository.UsuarioRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService{

    private final UsuarioRepositoy usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepositoy usuarioRepository){
        this.usuarioRepository =usuarioRepository;
    }

    //crear usuario
    public Usuario crear(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //editar usuario
    public Usuario modificar(Usuario usuario, Long id) {
        Usuario usuarioModificado = usuarioRepository.getById(id);

        if (!usuario.getNombre().trim().isEmpty()) {
            usuarioModificado.setNombre(usuario.getNombre());
        }
        if (!usuario.getApellido().trim().isEmpty()) {
            usuarioModificado.setApellido(usuario.getApellido());
        }
        if (!usuario.getUsername().trim().isEmpty()) {
            usuarioModificado.setUsername(usuario.getUsername());
        }
        if (!usuario.getPassword().trim().isEmpty()) {
            usuarioModificado.setPassword(usuario.getPassword());
        }
        if (!usuario.getCiudad().trim().isEmpty()) {
            usuarioModificado.setCiudad(usuario.getCiudad());
        }
        if (!usuario.getProvincia().trim().isEmpty()) {
            usuarioModificado.setProvincia(usuario.getProvincia());
        }
        if (!usuario.getPais().trim().isEmpty()) {
            usuarioModificado.setPais(usuario.getPais());
        }
        if (usuario.getTipoUsuario() != null) {
            usuarioModificado.setTipoUsuario(usuario.getTipoUsuario());
        }

        return usuarioRepository.save(usuarioModificado);
    }

    //eliminar usuario creado
    public Usuario eliminar(Usuario usuario, Long id){
        Usuario usuarioEliminado = usuarioRepository.getById(id);
        usuarioEliminado.setActivo(false);
        return usuarioRepository.save(usuarioEliminado);
    }

    //mostrar todos los usuarios
    public List<Usuario> todosLosUsuarios(LocalDate fechaCreacion, String ciudad) {

        if (fechaCreacion != null) {
            return usuarioRepository.findByFechaDeCreacion(fechaCreacion);
        }
        else if (ciudad != null) {
            return usuarioRepository.findByCiudad(ciudad);
        }
        else {
            return usuarioRepository.findAll();
        }
    }
}

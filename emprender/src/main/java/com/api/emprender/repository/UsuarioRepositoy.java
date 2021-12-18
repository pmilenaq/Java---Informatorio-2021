package com.api.emprender.repository;

import com.api.emprender.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepositoy extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String owner);
    List<Usuario> findByCiudad(String ciudad);
    @Query("from Usuario where fechaDeCreacion >= ?1")
    List<Usuario> findByFechaDeCreacion(LocalDate fechaDeCreacion);
}

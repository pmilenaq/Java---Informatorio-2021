package com.api.emprender.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private GeneradoPor generadoPor;
    private Long emprendimientoId;
    private Long usuarioId;
    @CreationTimestamp
    private LocalDate fechaDeCreacion;
    private String Observacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GeneradoPor getGeneradoPor() {
        return generadoPor;
    }

    public void setGeneradoPor(GeneradoPor generadoPor) {
        this.generadoPor = generadoPor;
    }

    public Long getEmprendimientoId() {
        return emprendimientoId;
    }

    public void setEmprendimientoId(Long emprendimientoId) {
        this.emprendimientoId = emprendimientoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String observacion) {
        Observacion = observacion;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", generadoPor=" + generadoPor +
                ", emprendimientoId=" + emprendimientoId +
                ", usuarioId=" + usuarioId +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", Observacion='" + Observacion + '\'' +
                '}';
    }
}
package com.api.emprender.DTO;

import com.api.emprender.entity.GeneradoPor;

import java.time.LocalDate;

public class VotoDTO {
    private GeneradoPor generadoPor;
    private Long usuarioId;
    private Long emprendimientoId;
    private LocalDate fechaDeCreacion;
    private boolean votar;

    public GeneradoPor getGeneradoPor(){
        return generadoPor;
    }

    public void setGeneradoPor(GeneradoPor generadoPor) {
        this.generadoPor = generadoPor;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getEmprendimientoId() {
        return emprendimientoId;
    }

    public void setEmprendimientoId(Long emprendimientoId) {
        this.emprendimientoId = emprendimientoId;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public boolean isVotar() {
        return votar;
    }

    public void setVotar(boolean votar) {
        this.votar = votar;
    }
}
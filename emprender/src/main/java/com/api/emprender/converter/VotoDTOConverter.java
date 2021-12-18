package com.api.emprender.converter;

import com.api.emprender.DTO.VotoDTO;
import com.api.emprender.entity.Voto;
import com.api.emprender.repository.EmprendimientoRepository;
import com.api.emprender.repository.UsuarioRepositoy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VotoDTOConverter implements Converter<VotoDTO, Voto> {

    public VotoDTOConverter(EmprendimientoRepository emprendimientoRepository,
                            UsuarioRepositoy usuarioRepository) {
    }

    @Override
    public Voto convert(VotoDTO votoDto) {
        Voto voto = new Voto();
        voto.setGeneradoPor(votoDto.getGeneradoPor());
        voto.setUsuarioId(votoDto.getUsuarioId());
        voto.setEmprendimientoId(votoDto.getEmprendimientoId());
        voto.setFechaDeCreacion(LocalDate.now());
        return voto;
    }
}
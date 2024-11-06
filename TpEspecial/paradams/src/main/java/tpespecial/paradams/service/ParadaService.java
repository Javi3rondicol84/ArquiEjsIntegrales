package tpespecial.paradams.service;

import tpespecial.paradams.dto.ParadaDto;

import java.util.List;

public interface ParadaService {
    List<ParadaDto> getAll();
    ParadaDto getById(Long id);
    ParadaDto create(ParadaDto ParadaDto);
    ParadaDto update(Long id, ParadaDto paradaDto);
    ParadaDto delete(Long id);
    int ubicarEnParada(String gps);

}

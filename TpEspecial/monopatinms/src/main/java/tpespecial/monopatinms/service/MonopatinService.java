package tpespecial.monopatinms.service;

import tpespecial.monopatinms.dto.MonopatinDto;

import java.util.List;

public interface MonopatinService {
    List<MonopatinDto> getAll();
    MonopatinDto getById(Long id);
    MonopatinDto create(MonopatinDto monopatinDto);
    MonopatinDto update(Long id, MonopatinDto monopatinDto);
    MonopatinDto delete(Long id);
    MonopatinDto mantenimiento(boolean habilitado,Long id);
    MonopatinDto agregarEnParada(String gps,Long id);
    List<MonopatinDto> reporteKilometros();
    List<MonopatinDto> reporteTiempoConPausa();
    List<MonopatinDto> reporteTiempoSinPausa();
}

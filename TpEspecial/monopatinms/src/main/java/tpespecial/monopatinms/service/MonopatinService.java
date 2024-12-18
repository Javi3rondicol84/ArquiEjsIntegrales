package tpespecial.monopatinms.service;

import tpespecial.monopatinms.dto.CantidadMonopatinesDto;
import tpespecial.monopatinms.dto.MonopatinDto;

import java.util.List;

public interface MonopatinService {
    List<MonopatinDto> getAll();
    MonopatinDto getById(Long id);
    MonopatinDto create(MonopatinDto monopatinDto);
    MonopatinDto update(Long id, MonopatinDto monopatinDto);
    MonopatinDto delete(Long id);
    MonopatinDto mantenimiento(boolean habilitado,Long id);
    CantidadMonopatinesDto monopatinesMantenimientoVsOperacion();
    List<MonopatinDto> monopatinesCercanos(String ubicacion);
}

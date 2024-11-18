package tpespecial.monopatinms.service;

import tpespecial.monopatinms.dto.CantidadMonopatinesDto;
import tpespecial.monopatinms.dto.MonopatinDto;

import java.util.List;

public interface MonopatinService {
    List<MonopatinDto> getAll();
    MonopatinDto getById(String id);
    MonopatinDto create(MonopatinDto monopatinDto);
    MonopatinDto update(String id, MonopatinDto monopatinDto);
    MonopatinDto delete(String id);
    MonopatinDto mantenimiento(boolean habilitado,String id);
    CantidadMonopatinesDto monopatinesMantenimientoVsOperacion();
    List<MonopatinDto> monopatinesCercanos(String ubicacion);

    void deleteAllMonopatines();
}

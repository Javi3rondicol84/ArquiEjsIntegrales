package tpespecial.administradorms.service;

import tpespecial.administradorms.dto.MantenimientoDto;
import tpespecial.administradorms.entity.Mantenimiento;

import java.util.List;

public interface MantenimientoService {
    List<MantenimientoDto> getAllMantenimiento();
    MantenimientoDto getMantenimientoById(Long id);
    MantenimientoDto add(MantenimientoDto mantenimientoDto);
    MantenimientoDto update(Long id, MantenimientoDto mantenimientoDto);
    MantenimientoDto delete(Long id);
}

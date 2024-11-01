package tpespecial.administradorms.service;

import tpespecial.administradorms.dto.MantenimientoDto;
import tpespecial.administradorms.dto.ReporteKilometrosDto;
import tpespecial.administradorms.dto.ReporteTiempoDto;
import tpespecial.administradorms.entity.Mantenimiento;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Viaje;

import java.util.List;

public interface MantenimientoService {
    List<MantenimientoDto> getAllMantenimiento();
    MantenimientoDto getMantenimientoById(Long id);
    MantenimientoDto add(MantenimientoDto mantenimientoDto);
    MantenimientoDto update(Long id, MantenimientoDto mantenimientoDto);
    MantenimientoDto delete(Long id);
    List<Viaje> getAllViajes();
    List<Monopatin> getAllMonopatines();
    List<ReporteKilometrosDto> getReporteKilometros();
    List<ReporteTiempoDto> getReporteTiempoConPausa();
    List<ReporteTiempoDto> getReporteTiempoSinPausa();
}

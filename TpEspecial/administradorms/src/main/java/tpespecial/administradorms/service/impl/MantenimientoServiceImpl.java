package tpespecial.administradorms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.administradorms.dto.MantenimientoDto;
import tpespecial.administradorms.dto.ReporteKilometrosDto;
import tpespecial.administradorms.dto.ReporteTiempoDto;
import tpespecial.administradorms.entity.Mantenimiento;
import tpespecial.administradorms.feignclient.MonopatinFeignClient;
import tpespecial.administradorms.feignclient.ViajeFeignClient;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Viaje;
import tpespecial.administradorms.repository.MantenimientoRepository;
import tpespecial.administradorms.service.MantenimientoService;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class MantenimientoServiceImpl implements MantenimientoService {


    @Autowired
    MantenimientoRepository mantenimientoRepository;
    @Autowired
    ViajeFeignClient viajeFeignClient;
    @Autowired
    MonopatinFeignClient monopatinFeignClient;

    @Override
    public List<MantenimientoDto> getAllMantenimiento() {
        return mantenimientoRepository.getAll();
    }

    @Override
    public MantenimientoDto getMantenimientoById(Long id) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id).orElse(null);

        if(mantenimiento == null) {
            return null;
        }

        return new MantenimientoDto(mantenimiento.getFechaHoraMantenimiento());
    }

    @Override
    public MantenimientoDto add(MantenimientoDto mantenimientoDto) {
        if(mantenimientoDto == null) {
            return null;
        }
        Mantenimiento mantenimiento = new Mantenimiento(mantenimientoDto.getFechaHoraMantenimiento());
        mantenimientoRepository.save(mantenimiento);
        return mantenimientoDto;
    }

    @Override
    public MantenimientoDto update(Long id, MantenimientoDto mantenimientoDto) {
        if(id == null || mantenimientoDto == null) {
            return null;
        }

        Mantenimiento mantenimiento = mantenimientoRepository.findById(id).orElse(null);

        if(mantenimiento == null) {
            return null;
        }

        mantenimiento.setFechaHoraMantenimiento(mantenimientoDto.getFechaHoraMantenimiento());

        mantenimientoRepository.save(mantenimiento);

        return mantenimientoDto;
    }

    @Override
    public MantenimientoDto delete(Long id) {
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id).orElse(null);

        if(mantenimiento == null) {
            return null;
        }

        mantenimientoRepository.delete(mantenimiento);

        return new MantenimientoDto(mantenimiento.getFechaHoraMantenimiento());
    }

    @Override
    public List<Viaje> getAllViajes() {
        return viajeFeignClient.getAllViajes();
    }

    @Override
    public List<Monopatin> getAllMonopatines() {
        return monopatinFeignClient.getMonopatines();
    }

    public List<Viaje> getAllViajeMonopatin(Long idMonopatin){
        return viajeFeignClient.getAllViajesByMonopatin(idMonopatin);
    }
    @Override
    public List<ReporteKilometrosDto> getReporteKilometros() {
        List<Monopatin> monopatines = this.getAllMonopatines();
        double kilometrosTotales = 0;
        List<ReporteKilometrosDto> reportes = new LinkedList<>();
        for(Monopatin monopatin : monopatines) {
            List<Viaje> viajes = this.getAllViajeMonopatin(monopatin.getIdViaje());
            for(Viaje viaje : viajes) {
                kilometrosTotales = kilometrosTotales + viaje.getKilometros();
            }
            ReporteKilometrosDto reporte = new ReporteKilometrosDto(monopatin.getIdMonopatin(),kilometrosTotales);
            reportes.add(reporte);
        }
        return reportes;
    }

    @Override
    public List<ReporteTiempoDto> getReporteTiempoConPausa() {
        List<Monopatin> monopatines = this.getAllMonopatines();
        int tiempoTotalMinutos = 0;
        List<ReporteTiempoDto> reportes = new LinkedList<>();
        for(Monopatin monopatin : monopatines) {
            List<Viaje> viajes = this.getAllViajeMonopatin(monopatin.getIdViaje());
            for(Viaje viaje : viajes) {
                LocalTime horaInicio = viaje.getHoraInicio();
                LocalTime horaFin = viaje.getHoraFin();
                Duration duracion = Duration.between(horaInicio, horaFin);
                int minutosViaje = (int) duracion.toMinutes();
                tiempoTotalMinutos += minutosViaje - viaje.getTiempoPausado().getMinute();
            }
            int horas = tiempoTotalMinutos / 60;
            int minutos = tiempoTotalMinutos % 60;
            LocalTime tiempoConPausa = LocalTime.of(horas, minutos);
            ReporteTiempoDto reporte = new ReporteTiempoDto(monopatin.getIdMonopatin(),tiempoConPausa);
            reportes.add(reporte);
        }
        return reportes;
    }

    @Override
    public List<ReporteTiempoDto> getReporteTiempoSinPausa() {
        List<Monopatin> monopatines = this.getAllMonopatines();
        int tiempoTotalMinutos = 0;
        List<ReporteTiempoDto> reportes = new LinkedList<>();
        for(Monopatin monopatin : monopatines) {
            List<Viaje> viajes = this.getAllViajeMonopatin(monopatin.getIdViaje());
            for(Viaje viaje : viajes) {
                LocalTime horaInicio = viaje.getHoraInicio();
                LocalTime horaFin = viaje.getHoraFin();
                Duration duracion = Duration.between(horaInicio, horaFin);
                tiempoTotalMinutos += (int) duracion.toMinutes();
            }
            int horas = tiempoTotalMinutos / 60;
            int minutos = tiempoTotalMinutos % 60;
            LocalTime tiempoConPausa = LocalTime.of(horas, minutos);
            ReporteTiempoDto reporte = new ReporteTiempoDto(monopatin.getIdMonopatin(),tiempoConPausa);
            reportes.add(reporte);
        }
        return reportes;
    }

    @Override
    public Monopatin monopatinEnMantenimiento(boolean habilitado, Long id) {
        return monopatinFeignClient.mantenimiento(habilitado,id);
    }


}

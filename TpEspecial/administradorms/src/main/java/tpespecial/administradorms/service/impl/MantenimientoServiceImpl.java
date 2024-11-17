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

    public List<Viaje> getAllViajeMonopatin(String idMonopatin){
        return viajeFeignClient.getAllViajesByMonopatin(idMonopatin);
    }
    @Override
    public List<ReporteKilometrosDto> getReporteKilometros(boolean incluyePausa) {
        if(incluyePausa){
            List<Monopatin> monopatines = this.getAllMonopatines();
            double kilometrosTotales = 0;
            LocalTime tiempoPausaTotal = LocalTime.of(0, 0);
            List<ReporteKilometrosDto> reportes = new LinkedList<>();
            for(Monopatin monopatin : monopatines) {
                List<Viaje> viajes = this.getAllViajeMonopatin(monopatin.getIdMonopatin());
                for (Viaje viaje : viajes) {
                    kilometrosTotales = kilometrosTotales + viaje.getKilometros();
                    tiempoPausaTotal = tiempoPausaTotal
                            .plusHours(viaje.getTiempoPausado().getHour())
                            .plusMinutes(viaje.getTiempoPausado().getMinute())
                            .plusSeconds(viaje.getTiempoPausado().getSecond());
                }
                ReporteKilometrosDto reporte = new ReporteKilometrosDto(monopatin.getIdMonopatin(), kilometrosTotales, tiempoPausaTotal);
                reportes.add(reporte);
                kilometrosTotales = 0;
                tiempoPausaTotal = LocalTime.of(0, 0);
            }
            return reportes;
        }else{
            List<Monopatin> monopatines = this.getAllMonopatines();
            double kilometrosTotales = 0;
            List<ReporteKilometrosDto> reportes = new LinkedList<>();
            for(Monopatin monopatin : monopatines) {
                List<Viaje> viajes = this.getAllViajeMonopatin(monopatin.getIdMonopatin());
                for (Viaje viaje : viajes) {
                    kilometrosTotales = kilometrosTotales + viaje.getKilometros();
                }
                ReporteKilometrosDto reporte = new ReporteKilometrosDto(monopatin.getIdMonopatin(), kilometrosTotales,LocalTime.of(0, 0));
                reportes.add(reporte);
                kilometrosTotales = 0;
            }
            return reportes;
        }

    }

    @Override
    public List<ReporteTiempoDto> getReporteTiempoConPausa() {
        List<ReporteTiempoDto> reportes = viajeFeignClient.getReporteTiempoConPausa();
        return reportes;
    }

    @Override
    public List<ReporteTiempoDto> getReporteTiempoSinPausa() {
        return null;
    }

    @Override
    public Monopatin monopatinEnMantenimiento(boolean habilitado, String id) {
        return monopatinFeignClient.mantenimiento(habilitado,id);
    }


}

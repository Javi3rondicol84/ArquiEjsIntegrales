package tpespecial.administradorms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.administradorms.dto.MantenimientoDto;
import tpespecial.administradorms.dto.ReporteKilometrosDto;
import tpespecial.administradorms.entity.Mantenimiento;
import tpespecial.administradorms.feignclient.ViajeFeignClient;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Viaje;
import tpespecial.administradorms.repository.MantenimientoRepository;
import tpespecial.administradorms.service.MantenimientoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MantenimientoServiceImpl implements MantenimientoService {


    @Autowired
    MantenimientoRepository mantenimientoRepository;
    @Autowired
    ViajeFeignClient viajeFeignClient;

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

    public List<Viaje> getAllMonopatViaje(Long idMonopatin){
        return viajeFeignClient.getAllViajesByMonopatin(idMonopatin);
    }
    @Override
    public List<ReporteKilometrosDto> generarReporteKilometros(List<Monopatin> monopatines) {
        double kilometrosTotales = 0;
        List<ReporteKilometrosDto> reportes = new ArrayList<>();
        for(Monopatin monopatin : monopatines) {
            List<Viaje> viajes = this.getAllMonopatViaje(monopatin.getIdViaje());
            for(Viaje viaje : viajes) {
                kilometrosTotales = kilometrosTotales + viaje.getKilometros();
            }
            ReporteKilometrosDto reporte = new ReporteKilometrosDto(monopatin.getIdMonopatin(),kilometrosTotales);
            reportes.add(reporte);
        }
        return reportes;
    }


}

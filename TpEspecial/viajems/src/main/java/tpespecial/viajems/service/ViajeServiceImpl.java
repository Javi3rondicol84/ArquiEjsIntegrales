package tpespecial.viajems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tpespecial.viajems.dto.ReporteTiempoDto;
import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;
import tpespecial.viajems.repository.ViajeRepository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ViajeServiceImpl implements ViajeService{
    @Autowired
    private ViajeRepository viajeRepository;

    public List<ViajeDto> getAllViajes() {
        return viajeRepository.getAllViajes();
    }

    public ViajeDto getViajeById(Long id) {
        Viaje viaje = viajeRepository.findById(id).orElse(null);
        if(viaje == null){
            return null;
        }
        return new ViajeDto(viaje.getIdMonopatin(), viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado(),viaje.getPrecio(),viaje.getTarifaExtra());
    }

    public ViajeDto addViaje(ViajeDto viaje) {
        if(viaje == null){
            return null;
        }
        Viaje viajeReal = new Viaje(viaje.getIdMonopatin(), viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado(),viaje.getPrecio(),viaje.getTarifaExtra());
        viajeRepository.save(viajeReal);
        return viaje;
    }

    public ViajeDto updateViaje(ViajeDto viaje, Long id) {
        Viaje viajeReal = viajeRepository.findById(id).orElse(null);
        if(viajeReal == null){
            return null;
        }
        viajeReal.setFechaIni(viaje.getFechaIni());
        viajeReal.setFechaFin(viaje.getFechaFin());
        viajeReal.setHoraInicio(viaje.getHoraInicio());
        viajeReal.setHoraFin(viaje.getHoraFin());
        viajeReal.setKilometros(viaje.getKilometros());
        viajeReal.setParada(viaje.getParada());
        viajeReal.setPausa(viaje.isPausa());
        viajeReal.setTiempoPausado(viaje.getTiempoPausado());
        viajeReal.setPrecio(viaje.getPrecio());
        viajeReal.setTarifaExtra(viaje.getTarifaExtra());
        viajeRepository.save(viajeReal);
        return viaje;
    }

    public ViajeDto updatePrecioViaje(double precio, Long id) {
        Viaje viaje = viajeRepository.findById(id).orElse(null);
        if(viaje == null){
            return null;
        }
        viaje.setPrecio(precio);
        viajeRepository.save(viaje);
        return new ViajeDto(viaje.getIdMonopatin(), viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado(),viaje.getPrecio(),viaje.getTarifaExtra());
    }

    public ViajeDto updateTarifaViaje(double tarifaExtra, Long id) {
        Viaje viaje = viajeRepository.findById(id).orElse(null);
        if(viaje == null){
            return null;
        }
        viaje.setTarifaExtra(tarifaExtra);
        viajeRepository.save(viaje);
        return new ViajeDto(viaje.getIdMonopatin(), viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado(),viaje.getPrecio(),viaje.getTarifaExtra());
    }

    @Override
    public List<Viaje> getAllViajesByMonopatin(Long id) {
        List<Viaje> viajes = viajeRepository.getAllViajesByMonopatin(id);
        return viajes;
    }

    @Override
    public List<ReporteTiempoDto> getReporteTiempoConPausa() {
        List<ReporteTiempoDto> reportes = new ArrayList<>();
        List<Object[]> results = viajeRepository.getReporteTiempoConPausa();

        for (Object[] row : results) {
            Long idMonopatin = ((Number) row[0]).longValue();
            Long tiempoTotal = ((Number) row[1]).longValue();
            Long tiempoSinPausa = ((Number) row[2]).longValue();
            Long duracionPausaSegundos = ((Number) row[3]).longValue();

            // Convertir los segundos de duracionPausa a LocalTime
            LocalTime duracionPausa = LocalTime.ofSecondOfDay(duracionPausaSegundos);

            // Crear el DTO y agregarlo a la lista
            ReporteTiempoDto reporte = new ReporteTiempoDto(idMonopatin, tiempoTotal, tiempoSinPausa, duracionPausa);
            reportes.add(reporte);
        }

        return reportes;
    }

    @Override
    public List<ReporteTiempoDto> getReporteTiempoSinPausa() {
        List<ReporteTiempoDto> reportes = new ArrayList<>();
        List<Object[]> results = viajeRepository.getReporteTiempoConPausa();

        for (Object[] row : results) {
            Long idMonopatin = ((Number) row[0]).longValue();
            Long tiempoTotal = ((Number) row[1]).longValue();
            Long tiempoSinPausa = ((Number) row[2]).longValue();
            Long duracionPausaSegundos = ((Number) row[3]).longValue();

            // Convertir los segundos de duracionPausa a LocalTime
            LocalTime duracionPausa = LocalTime.ofSecondOfDay(duracionPausaSegundos);

            // Crear el DTO y agregarlo a la lista
            ReporteTiempoDto reporte = new ReporteTiempoDto(idMonopatin, tiempoTotal, tiempoSinPausa, duracionPausa);
            reportes.add(reporte);
        }

        return reportes;
    }

    public ViajeDto deleteViaje(Long id) {
        Viaje viaje = viajeRepository.findById(id).orElse(null);
        if(viaje == null){
            return null;
        }
        viajeRepository.delete(viaje);
        return new ViajeDto(viaje.getIdMonopatin(), viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado(),viaje.getPrecio(),viaje.getTarifaExtra());
    }
}

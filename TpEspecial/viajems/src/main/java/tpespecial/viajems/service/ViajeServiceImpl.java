package tpespecial.viajems.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
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
@Data
public class ViajeServiceImpl implements ViajeService{
    @Autowired
    private ViajeRepository viajeRepository;
    private double precioViaje = 100;
    private double precioTarifa = 50;



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
        double tarifaExtra = 0;
        LocalTime quinceMin = LocalTime.of(0, 15);
        if(viaje == null){
            return null;
        }
        if(viaje.getTiempoPausado().isAfter(quinceMin)){
            tarifaExtra = precioTarifa;
        }
        Viaje viajeReal = new Viaje(viaje.getIdMonopatin(), viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado(),this.precioViaje,tarifaExtra);
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

    @Override
    public boolean cumpleRequisitosMonopatin(Long id, int viajes, int anio) {
        int cantidad = viajeRepository.cumpleRequisitosMonopatin(id,anio);
        return cantidad > viajes;
    }

    @Override
    public double totalFacturado(int mes1, int mes2, int anio) {
        LocalTime quinceMin = LocalTime.of(0, 15);
        return viajeRepository.totalFacturado(mes1,mes2,anio, quinceMin);
    }

    @Override
    public void actualizarPrecios(double tarifa, double precio) {
        this.setPrecioTarifa(tarifa);
        this.setPrecioViaje(precio);
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

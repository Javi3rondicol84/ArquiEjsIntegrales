package tpespecial.viajems.service;

import tpespecial.viajems.dto.ReporteTiempoDto;
import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;

import java.util.List;

public interface ViajeService {
    List<ViajeDto> getAllViajes();
    ViajeDto getViajeById(Long id);
    ViajeDto addViaje(ViajeDto viaje);
    ViajeDto updateViaje(ViajeDto viaje, Long id);
    ViajeDto deleteViaje(Long id);
    ViajeDto updatePrecioViaje(double precio, Long id);
    ViajeDto updateTarifaViaje(double tarifaExtra, Long id);
    List<Viaje> getAllViajesByMonopatin(Long id);
    List<ReporteTiempoDto> getReporteTiempoConPausa();
    List<ReporteTiempoDto> getReporteTiempoSinPausa();
    boolean cumpleRequisitosMonopatin(Long id, int viajes, int anio);
    Double totalFacturado(int mes1, int mes2, int anio);
    void actualizarPrecios(double tarifa, double precio);
}

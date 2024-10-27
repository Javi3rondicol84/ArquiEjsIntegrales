package tpespecial.viajems.service;

import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;

import java.util.List;

public interface ViajeService {
    List<ViajeDto> getAllViajes();
    ViajeDto getViajeById(Long id);
    ViajeDto addViaje(Viaje viaje);
    ViajeDto updateViaje(Viaje viaje, Long id);
    ViajeDto deleteViaje(Long id);


}

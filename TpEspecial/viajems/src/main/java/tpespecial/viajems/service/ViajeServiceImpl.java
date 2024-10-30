package tpespecial.viajems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;
import tpespecial.viajems.repository.ViajeRepository;

import java.util.List;

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
        return new ViajeDto(viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado());
    }

    public ViajeDto addViaje(ViajeDto viaje) {
        if(viaje == null){
            return null;
        }
        Viaje viajeReal = new Viaje(viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado());
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
        return new ViajeDto(viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado());
    }

    public ViajeDto deleteViaje(Long id) {
        Viaje viaje = viajeRepository.findById(id).orElse(null);
        if(viaje == null){
            return null;
        }
        viajeRepository.delete(viaje);
        return new ViajeDto(viaje.getFechaIni(),viaje.getFechaFin(),viaje.getHoraInicio(),viaje.getHoraFin(),viaje.getKilometros(),viaje.getParada(),viaje.isPausa(),viaje.getTiempoPausado());
    }
}

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

    @Override
    public List<ViajeDto> getAllViajes() {
        //return viajeRepository.findAll();
        return null;
    }

    @Override
    public ViajeDto getViajeById(Long id) {
        //return viajeRepository.findById(id);
        return null;
    }

    @Override
    public ViajeDto addViaje(Viaje viaje) {
        //return viajeRepository.save(viaje);
        return null;
    }

    @Override
    public ViajeDto updateViaje(Viaje viaje, Long id) {
        //return viajeRepository.findById(id).orElse(viaje);
        return null;
    }

    @Override
    public ViajeDto deleteViaje(Long id) {
        //return viajeRepository.deleteById(id);
        return null;
    }
}

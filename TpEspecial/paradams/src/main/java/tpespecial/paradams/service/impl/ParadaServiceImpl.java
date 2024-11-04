package tpespecial.paradams.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.paradams.dto.ParadaDto;
import tpespecial.paradams.entity.Parada;
import tpespecial.paradams.repository.ParadaRepository;
import tpespecial.paradams.service.ParadaService;

import java.util.List;

@Service
public class ParadaServiceImpl implements ParadaService {

    @Autowired
    private ParadaRepository ParadaRepository;

    @Override
    public List<ParadaDto> getAll() {
        return ParadaRepository.getAll();
    }

    @Override
    public ParadaDto getById(Long id) {
        Parada parada = ParadaRepository.findById(id).orElse(null);
        if(parada == null){
            return null;
        }

        return new ParadaDto(parada.getNombreparada());
    }

    @Override
    public ParadaDto create(ParadaDto paradadto) {
        if(paradadto == null) {
            return null;
        }

        ParadaRepository.save(new Parada(paradadto.getNombreparada()));

        return paradadto;
    }

    @Override
    public ParadaDto update(Long id, ParadaDto paradaDto) {
        Parada parada = ParadaRepository.findById(id).orElse(null);
        if(parada == null) {
            return null;
        }

        parada.setNombreparada(paradaDto.getNombreparada());

        ParadaRepository.save(parada);

        return paradaDto;
    }

    @Override
    public ParadaDto delete(Long id) {
        Parada parada = ParadaRepository.findById(id).orElse(null);
        if(parada == null) {
            return null;
        }

        ParadaRepository.delete(parada);

        return new ParadaDto(parada.getNombreparada());
    }

}

package tpespecial.monopatinms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.monopatinms.dto.MonopatinDto;
import tpespecial.monopatinms.entity.Monopatin;
import tpespecial.monopatinms.repository.MonopatinRepository;
import tpespecial.monopatinms.service.MonopatinService;

import java.util.List;

@Service
public class MonopatinServiceImpl implements MonopatinService {
    @Autowired
    private MonopatinRepository monopatinRepository;

    @Override
    public List<MonopatinDto> getAll() {
        return monopatinRepository.getAll();
    }

    @Override
    public MonopatinDto getById(Long id) {
        Monopatin monopatin = monopatinRepository.getById(id);
        if(monopatin == null) {
            return null;
        }
        return new MonopatinDto(monopatin.isEncendido(), monopatin.getGps(), monopatin.getKilometrosRecorridos(), monopatin.getTiempoDeUso(), monopatin.isHabilitado());
    }

    @Override
    public MonopatinDto create(MonopatinDto monopatinDto) {
        if(monopatinDto == null) {
            return null;
        }

        monopatinRepository.save(new Monopatin(monopatinDto.isEncendido(), monopatinDto.getGps(), monopatinDto.getKilometrosRecorridos(), monopatinDto.getTiempoDeUso(), monopatinDto.isHabilitado()));

        return monopatinDto;
    }

    @Override
    public MonopatinDto update(Long id, MonopatinDto monopatinDto) {
        Monopatin monopatin = monopatinRepository.getById(id);

        if(monopatin == null) {
            return null;
        }

        monopatin.setGps(monopatinDto.getGps());
        monopatin.setEncendido(monopatinDto.isEncendido());
        monopatin.setHabilitado(monopatinDto.isHabilitado());
        monopatin.setTiempoDeUso(monopatinDto.getTiempoDeUso());
        monopatin.setKilometrosRecorridos(monopatinDto.getKilometrosRecorridos());

        monopatinRepository.save(monopatin);

        return monopatinDto;
    }

    @Override
    public MonopatinDto delete(Long id) {
        Monopatin monopatin = monopatinRepository.getById(id);

        if(monopatin == null) {
            return null;
        }

        monopatinRepository.delete(monopatin);

        return new MonopatinDto(monopatin.isEncendido(), monopatin.getGps(), monopatin.getKilometrosRecorridos(), monopatin.getTiempoDeUso(), monopatin.isHabilitado());
    }

}

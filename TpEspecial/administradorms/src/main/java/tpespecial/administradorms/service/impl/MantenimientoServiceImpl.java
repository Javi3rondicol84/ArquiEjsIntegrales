package tpespecial.administradorms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.administradorms.dto.MantenimientoDto;
import tpespecial.administradorms.entity.Mantenimiento;
import tpespecial.administradorms.repository.MantenimientoRepository;
import tpespecial.administradorms.service.MantenimientoService;

import java.util.List;

@Service
public class MantenimientoServiceImpl implements MantenimientoService {
    @Autowired
    MantenimientoRepository mantenimientoRepository;

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
}

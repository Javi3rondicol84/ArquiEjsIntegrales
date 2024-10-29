package tpespecial.usuarioms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.cuentams.dto.CuentaDto;
import tpespecial.cuentams.entity.Cuenta;
import tpespecial.cuentams.repository.CuentaRepository;
import tpespecial.cuentams.service.CuentaService;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<CuentaDto> getAll() {
        return cuentaRepository.getAll();
    }

    @Override
    public CuentaDto getById(Long id) {
        Cuenta cuenta = cuentaRepository.getById(id);
        if(cuenta == null) {
            return null;
        }
        return new CuentaDto(cuenta.getCreditos(), cuenta.getFechaDeCreacion(), cuenta.isHabilitada());
    }

    @Override
    public CuentaDto create(CuentaDto cuentaDto) {
        Cuenta cuenta = new Cuenta(cuentaDto.getCreditos(), cuentaDto.getFechaDeCreacion(), cuentaDto.isHabilitada());
        cuentaRepository.save(cuenta);
        return cuentaDto;
    }

    @Override
    public CuentaDto update(Long id, CuentaDto cuentaDto) {
        Cuenta cuenta = cuentaRepository.getById(id);

        if(cuenta == null) {
            return null;
        }

        cuenta.setCreditos(cuentaDto.getCreditos());
        cuenta.setFechaDeCreacion(cuentaDto.getFechaDeCreacion());
        cuenta.setHabilitada(cuentaDto.isHabilitada());
        cuentaRepository.save(cuenta);
        return cuentaDto;
    }

    @Override
    public CuentaDto delete(Long id) {
        Cuenta cuenta = cuentaRepository.getById(id);

        if(cuenta == null) {
            return null;
        }

        cuentaRepository.delete(cuenta);

        return new CuentaDto(cuenta.getCreditos(), cuenta.getFechaDeCreacion(), cuenta.isHabilitada());
    }

}

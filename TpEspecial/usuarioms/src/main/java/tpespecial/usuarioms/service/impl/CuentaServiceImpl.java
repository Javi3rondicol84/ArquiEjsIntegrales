package tpespecial.usuarioms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.usuarioms.dto.CuentaDto;
import tpespecial.usuarioms.entity.Cuenta;
import tpespecial.usuarioms.repository.CuentaRepository;
import tpespecial.usuarioms.service.CuentaService;

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
    public CuentaDto anularCuenta(boolean habilitado, Long id){
        Cuenta cuenta = cuentaRepository.findById(id).orElse(null);
        if(cuenta == null){
            return null;
        }
        cuenta.setHabilitada(habilitado);
        cuentaRepository.save(cuenta);
        return new CuentaDto(cuenta.getCreditos(), cuenta.getFechaDeCreacion(), cuenta.isHabilitada());
    }

    @Override
    public CuentaDto getById(Long id) {
        Cuenta cuenta = cuentaRepository.findById(id).orElse(null);
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

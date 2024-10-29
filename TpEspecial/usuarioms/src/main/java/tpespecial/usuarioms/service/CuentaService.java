package tpespecial.usuarioms.service;

import tpespecial.cuentams.dto.CuentaDto;

import java.util.List;

public interface CuentaService {
    List<CuentaDto> getAll();
    CuentaDto getById(Long id);
    CuentaDto create(CuentaDto cuentaDto);
    CuentaDto update(Long id, CuentaDto cuentaDto);
    CuentaDto delete(Long id);
    CuentaDto anularCuenta(boolean habilitado,Long id);
}

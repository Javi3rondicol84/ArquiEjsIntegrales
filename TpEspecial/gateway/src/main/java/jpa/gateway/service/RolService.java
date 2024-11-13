package jpa.gateway.service;

import jpa.gateway.dto.RolDto;

import java.util.List;

public interface RolService {
    List<RolDto> obtenerTodosLosRoles();
    RolDto obtenerRolPorId(Long id);
    RolDto agregarRol(RolDto rolDto);
    RolDto actualizarRol(Long id, RolDto rolDto);
    RolDto eliminarRol(Long id);
    void crearRolPorDefecto();
}

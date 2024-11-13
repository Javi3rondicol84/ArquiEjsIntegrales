package jpa.gateway.service;

import jpa.gateway.auth.ConstanteDeAutorizacion;
import jpa.gateway.dto.RolDto;
import jpa.gateway.entity.Rol;
import jpa.gateway.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService{
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolDto> obtenerTodosLosRoles() {
        return rolRepository.getAllRoles();
    }

    @Override
    public RolDto obtenerRolPorId(Long id) {
        Rol rol = rolRepository.findById(id).orElse(null);

        if(rol == null) {
            return null;
        }

        return new RolDto(rol.getNombreRol());
    }

    @Override
    public RolDto agregarRol(RolDto rolDto) {
        if(rolDto == null) {
            return null;
        }

        rolRepository.save(new Rol(rolDto.getNombreRol()));

        return rolDto;
    }

    @Override
    public RolDto actualizarRol(Long id, RolDto rolDto) {
        Rol rol = rolRepository.findById(id).orElse(null);

        if(rol == null || rolDto == null) {
            return null;
        }

        rol.setNombreRol(rolDto.getNombreRol());

        rolRepository.save(rol);

        return rolDto;
    }

    @Override
    public RolDto eliminarRol(Long id) {
        Rol role = rolRepository.findById(id).orElse(null);
        if(role == null) {
            return null;
        }

        rolRepository.delete(role);

        return new RolDto(role.getNombreRol());
    }

    @Override
    public void crearRolPorDefecto() {
        rolRepository.save(new Rol(ConstanteDeAutorizacion._USUARIO));
        rolRepository.save(new Rol(ConstanteDeAutorizacion._ADMINISTRADOR));
    }
}

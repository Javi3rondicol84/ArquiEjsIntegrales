package jpa.gateway.repository;

import feign.Param;
import jpa.gateway.dto.RolDto;
import jpa.gateway.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Long> {

    @Query("SELECT r.nombreRol FROM Rol r WHERE r.nombreRol = : nombre")
    Rol obtenerRolPorNombre(@Param("nombre") String nombre);

    @Query("SELECT r FROM Rol r WHERE r.nombreRol = 'USUARIO'")
    Rol crearRolPorDefecto();

    @Query("SELECT new jpa.gateway.dto.RolDto(r.nombreRol) FROM Rol r")
    List<RolDto> getAllRoles();
}

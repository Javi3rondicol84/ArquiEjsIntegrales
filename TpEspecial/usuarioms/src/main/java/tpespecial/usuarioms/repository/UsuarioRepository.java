package tpespecial.usuarioms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.usuarioms.dto.UsuarioDto;
import tpespecial.usuarioms.entity.Usuario;

import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    @Query("SELECT new tpespecial.usuarioms.dto.UsuarioDto(us.nombre,us.apellido,us.numeroTelefonico,us.email) FROM Usuario us")
    public List<UsuarioDto> getAllUsuarios();

}
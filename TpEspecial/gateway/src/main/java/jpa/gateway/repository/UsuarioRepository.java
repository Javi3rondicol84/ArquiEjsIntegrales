package jpa.gateway.repository;

import feign.Param;
import jpa.gateway.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT u.nombreUsuario FROM Usuario u WHERE u.nombreUsuario = : nombre")
    Usuario buscarUsuarioPorNombre(@Param("nombre") String nombre);
}

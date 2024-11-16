package jpa.gateway.repository;

import jpa.gateway.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombre")
    Usuario buscarUsuarioPorNombre(@Param("nombre") String nombre);
}

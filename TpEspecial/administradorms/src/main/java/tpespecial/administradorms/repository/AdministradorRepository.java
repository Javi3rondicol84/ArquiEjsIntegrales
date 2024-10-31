package tpespecial.administradorms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.administradorms.dto.AdministradorDto;
import tpespecial.administradorms.entity.Administrador;

import java.util.List;

public interface AdministradorRepository extends JpaRepository<Administrador,Long> {
    @Query("Select new tpespecial.administradorms.dto.AdministradorDto(a.nombre) FROM Administrador a")
    List<AdministradorDto> getAll();
}

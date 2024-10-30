package tpespecial.administradorms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.administradorms.dto.MantenimientoDto;
import tpespecial.administradorms.entity.Mantenimiento;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Viaje;

import java.util.List;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
    @Query("SELECT new tpespecial.administradorms.dto.MantenimientoDto(m.idMantenimiento) FROM Mantenimiento m")
    List<MantenimientoDto> getAll();

}

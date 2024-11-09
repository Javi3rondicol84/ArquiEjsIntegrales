package tpespecial.monopatinms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.monopatinms.dto.CantidadMonopatinesDto;
import tpespecial.monopatinms.dto.MonopatinDto;
import tpespecial.monopatinms.entity.Monopatin;

import java.util.List;

public interface MonopatinRepository extends JpaRepository<Monopatin, Long> {
    @Query("SELECT new tpespecial.monopatinms.dto.MonopatinDto(m.encendido, m.gps, m.kilometrosRecorridos, m.tiempoDeUso, m.habilitado) FROM Monopatin m")
    List<MonopatinDto> getAll();

    @Query("SELECT new tpespecial.monopatinms.dto.CantidadMonopatinesDto(" +
            "COUNT(CASE WHEN m.habilitado = true THEN m.idMonopatin END), " +
            "COUNT(CASE WHEN m.habilitado = false THEN m.idMonopatin END)) " +
            "FROM Monopatin m")
    CantidadMonopatinesDto monopatinesMantenimientoVsOperacion();
}

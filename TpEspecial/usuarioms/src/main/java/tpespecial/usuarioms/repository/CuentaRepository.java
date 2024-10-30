package tpespecial.usuarioms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.usuarioms.dto.CuentaDto;
import tpespecial.usuarioms.entity.Cuenta;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query("SELECT new tpespecial.usuarioms.dto.CuentaDto(c.creditos, c.fechaDeCreacion, c.habilitada) FROM Cuenta c")
    List<CuentaDto> getAll();


}

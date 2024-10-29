package tpespecial.usuarioms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.cuentams.dto.CuentaDto;
import tpespecial.cuentams.entity.Cuenta;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query("SELECT new tpespecial.cuentams.dto.CuentaDto(c.creditos, c.fechaDeCreacion, c.habilitada) FROM Cuenta c")
    List<CuentaDto> getAll();


}

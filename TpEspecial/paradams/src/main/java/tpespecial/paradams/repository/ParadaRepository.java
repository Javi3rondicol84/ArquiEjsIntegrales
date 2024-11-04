package tpespecial.paradams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.paradams.dto.ParadaDto;
import tpespecial.paradams.entity.Parada;

import java.util.List;

public interface ParadaRepository extends JpaRepository<Parada, Long> {
    @Query("SELECT new tpespecial.paradams.dto.ParadaDto(p.nombreparada) FROM Parada p")
    List<ParadaDto> getAll();

}

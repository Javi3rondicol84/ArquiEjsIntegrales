package tpespecial.paradams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tpespecial.paradams.dto.ParadaDto;
import tpespecial.paradams.entity.Parada;

import java.util.List;

public interface ParadaRepository extends JpaRepository<Parada, Long> {
    @Query("SELECT new tpespecial.paradams.dto.ParadaDto(p.nombreparada,p.idMonopatin) FROM Parada p")
    List<ParadaDto> getAll();
    @Query("SELECT COUNT(p.idMonopatin) FROM Parada p WHERE p.nombreparada = :gps")
    int ubicarEnParada(@Param ("gps") String gps);

}

package tpespecial.viajems.repository;



import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;

import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje,Long> {
        
    @Query("SELECT new tpespecial.viajems.dto.ViajeDto(v.idMonopatin, v.fechaIni,v.fechaFin,v.horaInicio,v.horaFin,v.kilometros,v.parada,v.pausa,v.tiempoPausado, v.precio, v.tarifaExtra) FROM Viaje v")
    List<ViajeDto> getAllViajes();

    @Query("SELECT v FROM Viaje v WHERE v.idMonopatin = :id")
    List<Viaje> getAllViajesByMonopatin(@Param Long id);
}

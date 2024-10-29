package tpespecial.viajems.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;

import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje,Long> {
        
    @Query("SELECT new tpespecial.viajems.dto.ViajeDto(v.fechaIni,v.fechaFin,v.horaInicio,v.horaFin,v.kilometros,v.parada,v.pausa,v.tiempoPausado) FROM Viaje v")
    List<ViajeDto> getAllViajes();
}

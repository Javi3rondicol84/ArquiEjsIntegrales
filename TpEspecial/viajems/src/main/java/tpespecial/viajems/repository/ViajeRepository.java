package tpespecial.viajems.repository;



import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.viajems.dto.ReporteTiempoDto;
import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;

import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje,Long> {
        
    @Query("SELECT new tpespecial.viajems.dto.ViajeDto(v.idMonopatin, v.fechaIni,v.fechaFin,v.horaInicio,v.horaFin,v.kilometros,v.parada,v.pausa,v.tiempoPausado, v.precio, v.tarifaExtra) FROM Viaje v")
    List<ViajeDto> getAllViajes();

    @Query("SELECT v FROM Viaje v WHERE v.idMonopatin = :id")
    List<Viaje> getAllViajesByMonopatin(@Param Long id);

        @Query(value = "SELECT id_monopatin, CONCAT(SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, hora_inicio, hora_fin))), ' ', SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, hora_inicio, hora_fin) - tiempo_pausado)), ' ', SEC_TO_TIME(SUM(tiempo_pausado))) AS tiempoTotalEnLinea FROM viaje v GROUP BY id_monopatin",nativeQuery = true)
    List<Object[]> getReporteTiempoConPausa();


    @Query(value = "SELECT id_monopatin, CONCAT(SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, hora_inicio, hora_fin))), ' ', SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, hora_inicio, hora_fin) - tiempo_pausado)), ' ', SEC_TO_TIME(SUM(tiempo_pausado))) AS tiempoTotalEnLinea FROM viaje v GROUP BY id_monopatin",nativeQuery = true)
    List<Object[]> getReporteTiempoSinPausa();

}

package tpespecial.viajems.repository;



import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tpespecial.viajems.dto.ReporteTiempoDto;
import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;

import java.time.LocalTime;
import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje,Long> {
        
    @Query("SELECT new tpespecial.viajems.dto.ViajeDto(v.idMonopatin, v.fechaIni,v.fechaFin,v.horaInicio,v.horaFin,v.kilometros,v.parada,v.pausa,v.tiempoPausado, v.precio, v.tarifaExtra) FROM Viaje v")
    List<ViajeDto> getAllViajes();

    @Query("SELECT v FROM Viaje v WHERE v.idMonopatin = :id")
    List<Viaje> getAllViajesByMonopatin(@Param String id);

    @Query(value = "SELECT v.id_monopatin, SUM(v.hora_inicio - v.hora_fin), SUM(((v.hora_inicio - v.hora_fin))) FROM viaje v", nativeQuery = true)
    List<Object[]> getReporteTiempoConPausa();

    @Query(value = "SELECT id_monopatin, CONCAT(SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, hora_inicio, hora_fin))), ' ', SEC_TO_TIME(SUM(TIMESTAMPDIFF(SECOND, hora_inicio, hora_fin) - tiempo_pausado)), ' ', SEC_TO_TIME(SUM(tiempo_pausado))) AS tiempoTotalEnLinea FROM viaje v GROUP BY id_monopatin",nativeQuery = true)
    List<Object[]> getReporteTiempoSinPausa();

    @Query("SELECT COUNT(v.idViaje) FROM Viaje v WHERE v.idMonopatin = :id AND YEAR(v.fechaIni) = :anio")
    int cumpleRequisitosMonopatin(@Param("id") String id, @Param("anio") int anio);

    @Query("SELECT SUM(CASE WHEN v.tiempoPausado > :quinceMin THEN v.precio + v.tarifaExtra ELSE v.precio END) " +
            "FROM Viaje v WHERE MONTH(v.fechaIni) BETWEEN :mes1 AND :mes2 AND YEAR(v.fechaIni) = :anio")
    Double totalFacturado(@Param("mes1") int mes1, @Param("mes2") int mes2, @Param("anio") int anio, @Param("quinceMin") LocalTime quinceMin);
}

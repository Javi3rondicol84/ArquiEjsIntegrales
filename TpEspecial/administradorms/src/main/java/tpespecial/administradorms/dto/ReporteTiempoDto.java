package tpespecial.administradorms.dto;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ReporteTiempoDto {
    private Long idMonopatin;
    private LocalTime tiempo;

    public ReporteTiempoDto(Long idMonopatin, LocalTime tiempo) {
        this.idMonopatin = idMonopatin;
        this.tiempo = tiempo;
    }
}

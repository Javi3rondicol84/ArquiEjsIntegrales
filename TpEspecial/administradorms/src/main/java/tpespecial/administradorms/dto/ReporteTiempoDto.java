package tpespecial.administradorms.dto;

import lombok.Data;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ReporteTiempoDto {
    private Long idMonopatin;
    private LocalTime tiempoTotal;
    private LocalTime tiempoSinPausa;
    private LocalTime tiempoConPausa;

    public ReporteTiempoDto(Long idMonopatin, LocalTime tiempoTotal, LocalTime tiempoConPausa, LocalTime tiempoSinPausa) {
        this.idMonopatin = idMonopatin;
        this.tiempoTotal = tiempoTotal;
        this.tiempoConPausa = tiempoConPausa;
        this.tiempoSinPausa = tiempoSinPausa;
    }
}

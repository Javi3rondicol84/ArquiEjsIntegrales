package tpespecial.viajems.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ReporteTiempoDto {
    private Long idMonopatin;
    private Long tiempoTotal;
    private Long tiempoSinPausa;
    private LocalTime duracionPausa;

    public ReporteTiempoDto(Long idMonopatin, Long tiempoTotal, Long tiempoSinPausa, LocalTime duracionPausa) {
        this.idMonopatin = idMonopatin;
        this.tiempoTotal = tiempoTotal;
        this.duracionPausa = duracionPausa;
        this.tiempoSinPausa = tiempoSinPausa;
    }
}

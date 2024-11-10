package tpespecial.viajems.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalTime;

@Data
public class ReporteTiempoDto {
    private Long idMonopatin;
    private BigDecimal tiempoTotal;
    private BigDecimal tiempoSinPausa;
    //private LocalTime duracionPausa;

    public ReporteTiempoDto(Long idMonopatin, BigDecimal tiempoTotal, BigDecimal tiempoSinPausa) {
        this.idMonopatin = idMonopatin;
        this.tiempoTotal = tiempoTotal;
        this.tiempoSinPausa = tiempoSinPausa;
    }

    private String formatTime(BigDecimal seconds) {
        long totalSeconds = seconds.longValue();
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long remainingSeconds = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }

}

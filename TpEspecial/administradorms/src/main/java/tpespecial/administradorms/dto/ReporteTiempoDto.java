package tpespecial.administradorms.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ReporteTiempoDto {
    private String idMonopatin;
    private BigDecimal tiempoTotal;
    private BigDecimal tiempoSinPausa;
    //private LocalTime duracionPausa;

    public ReporteTiempoDto(String idMonopatin, BigDecimal tiempoTotal, BigDecimal tiempoSinPausa) {
        this.idMonopatin = idMonopatin;
        this.tiempoTotal = tiempoTotal;
        this.tiempoSinPausa = tiempoSinPausa;
    }

    public String getTiempoTotalFormatted() {
        return formatTime(tiempoTotal);
    }

    public String getTiempoSinPausaFormatted() {
        return formatTime(tiempoSinPausa);
    }

    private String formatTime(BigDecimal seconds) {
        long totalSeconds = seconds.longValue();
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long remainingSeconds = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
}

package tpespecial.administradorms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;


@Data
public class ReporteKilometrosDto {
    private Long idMonopatin;
    private double kilometros;
    private LocalTime tiempoPausaTotal;

    public ReporteKilometrosDto(Long idMonopatin, double kilometros, LocalTime tiempoPausaTotal) {
        this.idMonopatin = idMonopatin;
        this.kilometros = kilometros;
        this.tiempoPausaTotal = tiempoPausaTotal;
    }
}

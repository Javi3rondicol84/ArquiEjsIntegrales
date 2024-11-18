package tpespecial.administradorms.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class Viaje {
    private String idMonopatin;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private double kilometros;
    private String parada;
    private boolean pausa;
    private LocalTime tiempoPausado;
    private double precio;
    private double tarifaExtra;
}

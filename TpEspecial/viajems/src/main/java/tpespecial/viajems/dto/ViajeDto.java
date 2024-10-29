package tpespecial.viajems.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class ViajeDto {

    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private double kilometros;
    private String parada;
    private boolean pausa;
    private LocalTime tiempoPausado;

    public ViajeDto(LocalDate fechaIni, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin, double kilometros, String parada, boolean pausa, LocalTime tiempoPausado) {
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.kilometros = kilometros;
        this.parada = parada;
        this.pausa = pausa;
        this.tiempoPausado = tiempoPausado;
    }

    public ViajeDto() {
    }




}

package tpespecial.viajems.entity;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

public class Viaje {
    private Long idViaje;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private double kilometros;
    private String parada;
    private boolean pausa;
    private LocalTime tiempoPausado;

}

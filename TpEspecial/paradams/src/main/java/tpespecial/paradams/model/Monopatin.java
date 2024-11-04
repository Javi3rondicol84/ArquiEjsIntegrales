package tpespecial.paradams.model;

import lombok.Data;

import java.time.LocalTime;
@Data
public class Monopatin {


    private boolean encendido;
    private String gps;
    private double kilometrosRecorridos;
    private LocalTime tiempoDeUso;
    private boolean habilitado;


    public Monopatin(boolean encendido, String gps, double kilometrosRecorridos, LocalTime tiempoDeUso, boolean habilitado) {
        this.encendido = encendido;
        this.gps = gps;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.tiempoDeUso = tiempoDeUso;
        this.habilitado = habilitado;
    }

}

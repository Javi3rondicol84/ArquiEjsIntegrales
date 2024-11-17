package tpespecial.monopatinms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
public class MonopatinDto {
    private String idMonopatin;
    private boolean encendido;
    private String gps;
    private double kilometrosRecorridos;
    private LocalTime tiempoDeUso;
    private boolean habilitado;

    public MonopatinDto(String idMonopatin,boolean encendido, String gps, double kilometrosRecorridos, LocalTime tiempoDeUso, boolean habilitado) {
        this.idMonopatin = idMonopatin;
        this.encendido = encendido;
        this.gps = gps;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.tiempoDeUso = tiempoDeUso;
        this.habilitado = habilitado;
    }
}

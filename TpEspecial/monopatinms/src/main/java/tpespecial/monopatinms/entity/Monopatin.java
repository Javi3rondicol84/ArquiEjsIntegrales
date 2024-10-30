package tpespecial.monopatinms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@Data
@Entity
public class Monopatin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMonopatin;
    private Long idViaje;
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

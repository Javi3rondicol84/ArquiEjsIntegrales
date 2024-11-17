package tpespecial.monopatinms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.time.LocalTime;

@NoArgsConstructor
@Data
@Document("Monopatin")
public class Monopatin {
    @Id
    private String idMonopatin;
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

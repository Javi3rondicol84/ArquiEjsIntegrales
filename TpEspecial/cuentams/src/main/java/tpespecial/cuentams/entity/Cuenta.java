package tpespecial.cuentams.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;
    //private ArrayList<UsuarioDto> usuarios;
    private Double creditos;
    private LocalDate fechaDeCreacion;
    private boolean habilitada;

    public Cuenta(Double creditos, LocalDate fechaDeCreacion, boolean habilitada) {
        this.creditos = creditos;
        this.fechaDeCreacion = fechaDeCreacion;
        this.habilitada = habilitada;
    }
}

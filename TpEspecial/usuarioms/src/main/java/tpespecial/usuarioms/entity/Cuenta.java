package tpespecial.usuarioms.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import tpespecial.usuarioms.entity.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;
    @ManyToMany
    private List<Usuario> usuarios;
    private Double creditos;
    private LocalDate fechaDeCreacion;
    private boolean habilitada;

    public Cuenta(Double creditos, LocalDate fechaDeCreacion, boolean habilitada) {
        this.creditos = creditos;
        this.fechaDeCreacion = fechaDeCreacion;
        this.habilitada = habilitada;
        this.usuarios = new ArrayList<>();
    }
}

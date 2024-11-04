package tpespecial.administradorms.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Cuenta {
    private Double creditos;
    private LocalDate fechaDeCreacion;
    private boolean habilitada;
}

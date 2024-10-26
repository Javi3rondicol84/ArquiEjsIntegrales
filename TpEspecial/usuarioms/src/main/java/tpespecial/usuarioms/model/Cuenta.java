package tpespecial.usuarioms.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import tpespecial.usuarioms.dto.UsuarioDto;

import java.time.LocalDate;
import java.util.ArrayList;
@Data

public class Cuenta {

    private ArrayList<UsuarioDto> usuarios;
    private Double creditos;
    private LocalDate fechaDeCreacion;
    private boolean habilitada;

    public Cuenta(Double creditos, LocalDate fechaDeCreacion, boolean habilitada) {
        this.creditos = creditos;
        this.fechaDeCreacion = fechaDeCreacion;
        this.habilitada = habilitada;
    }

    public Cuenta(){
        this.usuarios = new ArrayList<>();
    }
}

package tpespecial.usuarioms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class CuentaDto {
   // private Long idCuenta;
    //private ArrayList<UsuarioDto> usuarios;
    private Double creditos;
    private LocalDate fechaDeCreacion;
    private boolean habilitada;

    public CuentaDto(Double creditos, LocalDate fechaDeCreacion, boolean habilitada) {
        this.creditos = creditos;
        this.fechaDeCreacion = fechaDeCreacion;
        this.habilitada = habilitada;
    }
}

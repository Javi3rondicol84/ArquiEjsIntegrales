package tpespecial.cuentams.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import tpespecial.usuarioms.dto.UsuarioDto;
public class Cuenta {
    private Long idCuenta;
    private ArrayList<UsuarioDto> usuarios;
    private double creditos;
    private LocalDate fechaDeCreacion;
    private boolean habilitada;

}

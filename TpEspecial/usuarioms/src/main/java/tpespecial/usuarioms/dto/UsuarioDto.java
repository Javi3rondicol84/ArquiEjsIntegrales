package tpespecial.usuarioms.dto;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data

public class UsuarioDto {
    private List<CuentaDto> cuentas;
    private String nombre;
    private String apellido;
    private int numeroTelefonico;
    private String email;

    public UsuarioDto(String nombre, String apellido, int numeroTelefonico, String email) {
        this.cuentas=new ArrayList<>();
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
    }

    public UsuarioDto(){
        this.cuentas=new ArrayList<>();
    }
}

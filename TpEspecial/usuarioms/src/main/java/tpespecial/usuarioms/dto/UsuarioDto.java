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
    private String gps;

    public UsuarioDto(String nombre, String apellido, int numeroTelefonico, String email, String gps) {
        this.cuentas=new ArrayList<>();
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
        this.gps = gps;
    }

    public UsuarioDto(){
        this.cuentas=new ArrayList<>();
    }
}

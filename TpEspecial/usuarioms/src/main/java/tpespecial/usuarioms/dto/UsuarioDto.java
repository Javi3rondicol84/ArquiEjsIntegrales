package tpespecial.usuarioms.dto;

import lombok.Data;
import tpespecial.usuarioms.model.Cuenta;

import java.util.ArrayList;

@Data

public class UsuarioDto {
    private ArrayList<Cuenta> cuentas;
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

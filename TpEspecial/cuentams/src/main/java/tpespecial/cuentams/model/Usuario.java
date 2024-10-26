package tpespecial.cuentams.model;

import tpespecial.cuentams.dto.CuentaDto;

import java.util.ArrayList;

public class Usuario {

    private ArrayList<CuentaDto> cuentas;
    private String nombre;
    private String apellido;
    private int numeroTelefonico;
    private String email;

    public Usuario(String nombre, String apellido, int numeroTelefonico, String email) {
        this.cuentas=new ArrayList<>();
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefonico = numeroTelefonico;
        this.email = email;
    }
}

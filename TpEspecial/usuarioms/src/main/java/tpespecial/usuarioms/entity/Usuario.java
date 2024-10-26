package tpespecial.usuarioms.entity;
import jakarta.persistence.*;
import lombok.Data;

import tpespecial.usuarioms.model.Cuenta;

import java.util.ArrayList;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUsuario;
    //@ManyToMany(mappedBy="usuarios")
    @Transient
    private ArrayList<Cuenta> cuentas;
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

    public Usuario(){
        this.cuentas=new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
}

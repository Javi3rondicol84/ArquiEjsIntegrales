package jpa.gateway.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudRegistro {
    private String nombreUsurio;
    private String contrasenia;
    private String rol;

    public void setRol(String rol) {
        this.rol = rol.toUpperCase();
    }
}

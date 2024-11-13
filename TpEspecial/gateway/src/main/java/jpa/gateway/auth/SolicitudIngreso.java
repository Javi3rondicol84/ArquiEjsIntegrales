package jpa.gateway.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudIngreso {
    private String nombreUsurio;
    private String contrasenia;
}

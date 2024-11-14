package jpa.gateway.auth;

public interface AuthService {
    RespuestaAuth login(SolicitudIngreso solicitudIngreso);
    RespuestaAuth registrarse(SolicitudRegistro solicitudRegistro);
}

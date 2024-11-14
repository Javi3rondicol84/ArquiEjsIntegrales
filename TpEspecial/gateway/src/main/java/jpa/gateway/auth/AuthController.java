package jpa.gateway.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/login")
    public RespuestaAuth login(@RequestBody SolicitudIngreso solicitudIngreso){
        return authService.login(solicitudIngreso);
    }

    @PostMapping("/registrarse")
    public RespuestaAuth registrarse(@RequestBody SolicitudRegistro solicitudRegistro){
        return authService.registrarse(solicitudRegistro);
    }

}

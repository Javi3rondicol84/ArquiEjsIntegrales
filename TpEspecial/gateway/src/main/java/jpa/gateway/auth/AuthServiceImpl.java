package jpa.gateway.auth;

import jpa.gateway.entity.Rol;
import jpa.gateway.entity.Usuario;
import jpa.gateway.jwt.JwtService;
import jpa.gateway.repository.RolRepository;
import jpa.gateway.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public RespuestaAuth login(SolicitudIngreso solicitudIngreso) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(solicitudIngreso.getNombreUsurio(), solicitudIngreso.getContrasenia()));

        UserDetails user = usuarioRepository.buscarUsuarioPorNombre(solicitudIngreso.getNombreUsurio());

        if(user == null) {
            return null;
        }

        String token = jwtService.obtenerToken(user);

        return new RespuestaAuth(token);
    }

    @Override
    public RespuestaAuth registrarse(SolicitudRegistro solicitudRegistro) {
        Rol roleFound = rolRepository.obtenerRolPorNombre(solicitudRegistro.getRol());

        if(roleFound == null) {
            return new RespuestaAuth("No existe el rol");
        }

        Usuario user = new Usuario(solicitudRegistro.getNombreUsurio(), passwordEncoder.encode(solicitudRegistro.getContrasenia()));
        user.addRol(roleFound);

        usuarioRepository.save(user);

        return new RespuestaAuth(jwtService.obtenerToken(user));
    }
}

package jpa.gateway.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String LLAVE_SECRETA = "8rjjf6ehq9rufj4h4ghg9geyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";

    public String obtenerToken(UserDetails usuario) {
        Map<String, Object> extraClaims = new HashMap<>();

        // Crear una lista para almacenar los nombres de las autoridades
        List<String> listaDeAutoridades = new ArrayList<>();

        // Recorrer cada autoridad y añadirla a la lista
        for (GrantedAuthority authority : usuario.getAuthorities()) {
            listaDeAutoridades.add(authority.getAuthority());
        }

        // Unir las autoridades en una cadena separada por comas
        StringBuilder authorities = new StringBuilder();

        for (int i = 0; i < listaDeAutoridades.size(); i++) {
            authorities.append(listaDeAutoridades.get(i));
            if (i < listaDeAutoridades.size() - 1) {
                authorities.append(",");
            }
        }

        // Almacenar roles y permisos en los claims como lista de cadenas
        extraClaims.put("authorities", listaDeAutoridades);

        return obtenerToken(extraClaims, usuario);
    }

    private String obtenerToken(Map<String, Object> extraClaims, UserDetails usuario) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(usuario.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 8)) //8 horas
                .signWith(obtenerKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key obtenerKey(){
        byte[] keyBytes = Decoders.BASE64.decode(LLAVE_SECRETA);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String obtenerNombreUsuarioToken(String token){
        return obtenerClaim(token, Claims::getSubject);
    }

    public boolean esValidoToken(String token, UserDetails usuario){
        final String nombreUsuario = obtenerNombreUsuarioToken(token);
        return nombreUsuario.equals(usuario.getUsername()) && !estaExpiradoToken(token);
    }

    private Claims obtenerClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(obtenerKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T obtenerClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = obtenerClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date obtenerFechaExpiracion(String token){
        return obtenerClaim(token, Claims::getExpiration);
    }

    private boolean estaExpiradoToken(String token){
        return obtenerFechaExpiracion(token).before(new Date());
    }



}

package jpa.gateway.config;

import jpa.gateway.auth.ConstanteDeAutorizacion;
import jpa.gateway.entity.Usuario;
import jpa.gateway.jwt.FiltroAutenticacionJwt;
import jpa.gateway.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
        @Autowired
        private UsuarioRepository usuarioRepository;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http, FiltroAutenticacionJwt jwtAuthenticationFilter) throws Exception {
            return http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(authRequest -> authRequest
                            .requestMatchers("/auth/**").permitAll()
                            .requestMatchers("/holamundo").hasAuthority(ConstanteDeAutorizacion._USUARIO)
                            .requestMatchers("/chaumundo").hasAuthority(ConstanteDeAutorizacion._ADMINISTRADOR)
                            .anyRequest().authenticated())
                    .sessionManagement(sessionManager -> sessionManager
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authenticationProvider(this.authenticationProvider())
                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .httpBasic(httpBasic -> httpBasic.disable()) // Desactiva explícitamente la autenticación básica
                    .build();
        }

        @Bean
        public AuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
            authenticationProvider.setUserDetailsService(userDetailService());
            authenticationProvider.setPasswordEncoder(passwordEncoder());
            return authenticationProvider;
        }

        @Bean
        public UserDetailsService userDetailService() {
            return username -> {
                Usuario user = usuarioRepository.buscarUsuarioPorNombre(username);
                if (user == null) {
                    throw new UsernameNotFoundException("User not found");
                }
                return user;
            };
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
            return config.getAuthenticationManager();
        }


    }

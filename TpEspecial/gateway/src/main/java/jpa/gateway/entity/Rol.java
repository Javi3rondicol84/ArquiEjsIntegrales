package jpa.gateway.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    @Column(nullable = false, unique = true)
    private String nombreRol;

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }


}

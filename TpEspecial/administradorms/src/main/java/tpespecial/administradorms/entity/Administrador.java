package tpespecial.administradorms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Administrador {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAdministrador;
    private String nombre;

    public Administrador(String nombre) {
         this.nombre = nombre;
    }
}

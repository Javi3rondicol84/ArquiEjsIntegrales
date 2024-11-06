package tpespecial.paradams.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import tpespecial.paradams.model.Monopatin;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Parada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idparada;
    private String nombreparada;
    private Long idMonopatin;

    public Parada(String nombreparada, Long idMonopatin){
        this.nombreparada = nombreparada;
        this.idMonopatin = idMonopatin;
    }

}

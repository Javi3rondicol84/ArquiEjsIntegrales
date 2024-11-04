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
    @Transient
    private List<Long> monopatines;
    private String nombreparada;

    public Parada(String nombreparada){
        monopatines = new ArrayList<>();
        this.nombreparada = nombreparada;
    }


    public void addParada(Long idmonopatin){
        monopatines.add(idmonopatin);
    }

}

package tpespecial.paradams.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import tpespecial.paradams.model.MonopatinDto;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Parada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idparada;
    private List<MonopatinDto> monopatines;
    private String nombreparada;

    public Parada(String nombreparada){
        monopatines = new ArrayList<>();
        this.nombreparada = nombreparada;
    }


    public void addParada(MonopatinDto monopatinDto){
        monopatines.add(monopatinDto);
    }

}

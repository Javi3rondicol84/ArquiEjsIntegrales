package tpespecial.paradams.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import tpespecial.paradams.model.Monopatin;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ParadaDto {
    private List<Monopatin> monopatines;
    private String nombreparada;

    public ParadaDto(String nombreparada) {
        monopatines = new ArrayList<>();
        this.nombreparada = nombreparada;
    }
}

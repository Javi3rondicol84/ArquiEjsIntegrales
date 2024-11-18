package tpespecial.paradams.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import tpespecial.paradams.model.Monopatin;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ParadaDto {
    private String idMonopatin;
    private String nombreparada;

    public ParadaDto(String nombreparada,String idMonopatin) {
        this.idMonopatin = idMonopatin;
        this.nombreparada = nombreparada;
    }
}

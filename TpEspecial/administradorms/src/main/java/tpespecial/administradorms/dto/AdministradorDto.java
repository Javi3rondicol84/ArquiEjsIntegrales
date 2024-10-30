package tpespecial.administradorms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdministradorDto {
    private String nombre;

    public AdministradorDto(String nombre) {
        this.nombre = nombre;
    }

}

package tpespecial.administradorms.dto;

import lombok.Data;

@Data
public class CantidadMonopatinesDto {
    private Long cantidadOperacion;
    private Long cantidadMantenimiento;

    public CantidadMonopatinesDto(Long cantidadOperacion, Long cantidadMantenimiento) {
        this.cantidadOperacion = cantidadOperacion;
        this.cantidadMantenimiento = cantidadMantenimiento;
    }

}

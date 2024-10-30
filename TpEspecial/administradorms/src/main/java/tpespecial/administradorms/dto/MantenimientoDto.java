package tpespecial.administradorms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MantenimientoDto {
    private LocalDateTime fechaHoraMantenimiento;
}

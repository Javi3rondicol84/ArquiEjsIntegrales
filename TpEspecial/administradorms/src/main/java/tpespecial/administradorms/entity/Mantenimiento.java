package tpespecial.administradorms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
public class Mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMantenimiento;
    private LocalDateTime fechaHoraMantenimiento;

    public Mantenimiento(LocalDateTime fechaHoraMantenimiento) {
        this.fechaHoraMantenimiento = fechaHoraMantenimiento;
    }

}

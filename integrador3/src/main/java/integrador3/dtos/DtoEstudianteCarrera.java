package integrador3.dtos;

import integrador3.entities.Carrera;
import integrador3.entities.Estudiante;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DtoEstudianteCarrera {
    private Long carreraId;
    private LocalDate antiguedadCarrera;
    private String graduado;
    private LocalDate fechaInscripcion;
    private Long estudianteId;

    public DtoEstudianteCarrera(Long carreraId, LocalDate antiguedadCarrera, String graduado, LocalDate fechaInscripcion, Long estudianteId) {
        this.carreraId = carreraId;
        this.antiguedadCarrera = antiguedadCarrera;
        this.graduado = graduado;
        this.fechaInscripcion = fechaInscripcion;
        this.estudianteId = estudianteId;
    }

    public DtoEstudianteCarrera() {
    }


}

package integrador3.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"carrera_id","estudiante_id"}))
public class EstudianteCarrera {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idEstudianteCarrera;
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carreraInscripto;
    private LocalDate antiguedadCarrera;
    private String graduado;
    private LocalDate fechaInscripcion;
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    public EstudianteCarrera(Carrera carreraInscripto, LocalDate antiguedadCarrera, String graduado, Estudiante estudiante, LocalDate fechaInscripcion) {
        this.carreraInscripto = carreraInscripto;
        this.antiguedadCarrera = antiguedadCarrera;
        this.graduado = graduado;
        this.estudiante = estudiante;
        this.fechaInscripcion = fechaInscripcion;
    }

    public EstudianteCarrera() {
    }

    public void setGraduado(String graduado) {
         graduado = graduado.toLowerCase();
        if(graduado.equals("si") || graduado.equals("no")){
            this.graduado = graduado;
        }else{
            this.graduado = "no";
        }
    }

    @Override
    public String   toString() {
        return "EstudianteCarrera{" +
                "idEstudianteCarrera=" + idEstudianteCarrera +
                ", carreraInscripto=" + carreraInscripto +
                ", antiguedadCarrera=" + antiguedadCarrera +
                ", graduado='" + graduado + '\'' +
                ", fechaInscripcion=" + fechaInscripcion +
                ", estudiante=" + estudiante +
                '}';
    }
}

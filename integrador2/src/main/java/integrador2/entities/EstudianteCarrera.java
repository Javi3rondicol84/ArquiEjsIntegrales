package integrador2.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EstudianteCarrera {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idEstudianteCarrera;
    @OneToOne
    private Carrera carreraInscripto;
    private LocalDate antiguedadCarrera;
    private String graduado;
    @OneToOne
    private Estudiante estudiante;

    public EstudianteCarrera(Carrera carreraInscripto, LocalDate antiguedadCarrera, String graduado, Estudiante estudiante) {
        this.carreraInscripto = carreraInscripto;
        this.antiguedadCarrera = antiguedadCarrera;
        this.graduado = graduado;
        this.estudiante = estudiante;
    }

    public EstudianteCarrera() {
    }

    public int getIdEstudianteCarrera() {
        return idEstudianteCarrera;
    }

    public LocalDate getAntiguedadCarrera() {
        return antiguedadCarrera;
    }

    public void setAntiguedadCarrera(LocalDate antiguedadCarrera) {
        this.antiguedadCarrera = antiguedadCarrera;
    }

    public String getGraduado() {
        return graduado;
    }

    public void setGraduado(String graduado) {
         graduado = graduado.toLowerCase();
        if(graduado.equals("si") || graduado.equals("no")){
            this.graduado = graduado;
        }else{
            this.graduado = "no";
        }
    }

    public Carrera getCarreraInscripto() {
        return carreraInscripto;
    }

    public void setCarreraInscripto(Carrera carreraInscripto) {
        this.carreraInscripto = carreraInscripto;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "EstudianteCarrera{" +
                "idEstudianteCarrera=" + idEstudianteCarrera +
                ", carrerasInscripto=" + carreraInscripto +
                ", antiguedadCarrera=" + antiguedadCarrera +
                ", graduado='" + graduado + '\'' +
                ", estudiante=" + estudiante +
                '}';
    }
}

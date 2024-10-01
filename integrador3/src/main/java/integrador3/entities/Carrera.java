package integrador3.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCarrera;
    private String nombreCarrera;
    @OneToMany (mappedBy = "carreraInscripto",cascade = CascadeType.PERSIST)
    private List<EstudianteCarrera> estudiantes;

    public Carrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Carrera() {
    }

    public int getIdCarrera() {
        return idCarrera;
    }
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public void addEstudiante(EstudianteCarrera estudiante){
        estudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "idCarrera=" + idCarrera +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                '}';
    }
}


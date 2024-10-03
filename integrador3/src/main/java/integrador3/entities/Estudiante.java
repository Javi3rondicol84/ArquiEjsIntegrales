package integrador3.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private int dni;
    private String ciudad;
    private int numeroLibretaUniversitaria;
    @OneToMany (mappedBy = "estudiante", cascade = CascadeType.PERSIST)
    private List<EstudianteCarrera> carreras;

    public Estudiante(String nombre, String apellido, int edad, String genero, int dni, String ciudad, int numeroLibretaUniversitaria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudad = ciudad;
        this.numeroLibretaUniversitaria = numeroLibretaUniversitaria;
    }

    public Estudiante() {
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "idEstudiante=" + idEstudiante +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", dni=" + dni +
                ", ciudad='" + ciudad + '\'' +
                ", numeroLibretaUniversitaria=" + numeroLibretaUniversitaria +
                '}';
    }
}

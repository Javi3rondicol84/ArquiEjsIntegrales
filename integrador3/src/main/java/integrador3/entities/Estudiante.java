package integrador3.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstudiante;
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

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumeroLibretaUniversitaria() {
        return numeroLibretaUniversitaria;
    }

    public void addCarrera(EstudianteCarrera carrera){
        carreras.add(carrera);
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

package integrador2.dtos;

import java.time.LocalDate;

public class DtoCarreraCustom {
    String nombreCarrera;
    String nombre;
    String apellido;
    int edad;
    int antiguedadCarrera;

    public DtoCarreraCustom(String nombreCarrera, String nombre, String apellido, int edad, int antiguedadCarrera) {
        this.nombreCarrera = nombreCarrera;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.antiguedadCarrera = antiguedadCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    @Override
    public String toString() {
        return "DtoCarreraCustom{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", antiguedadCarrera=" + antiguedadCarrera +
                '}';
    }
}

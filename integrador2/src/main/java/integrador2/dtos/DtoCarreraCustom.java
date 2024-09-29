package integrador2.dtos;

import java.time.LocalDate;

public class DtoCarreraCustom {
    String nombreCarrera;
    int cantidadInscriptos;
    int anio;
    int egresadosPorAnio;

    public DtoCarreraCustom(String nombreCarrera, int cantidadInscriptos, int anio, int egresadosPorAnio) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadInscriptos = cantidadInscriptos;
        this.anio = anio;
        this.egresadosPorAnio = egresadosPorAnio;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public int getEgresadosPorAnio() {
        return egresadosPorAnio;
    }

    public void setEgresadosPorAnio(int egresadosPorAnio) {
        this.egresadosPorAnio = egresadosPorAnio;
    }

    public int getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public void setCantidadInscriptos(int cantidadInscriptos) {
        this.cantidadInscriptos = cantidadInscriptos;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "DtoCarreraCustom{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                ", cantidadInscriptos=" + cantidadInscriptos +
                ", anio=" + anio +
                ", egresadosPorAnio=" + egresadosPorAnio +
                "}\n";
    }
}

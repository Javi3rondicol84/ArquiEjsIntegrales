package integrador2.dtos;

public class DtoCarrera {
    String nombreCarrera;

    public DtoCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public DtoCarrera() {
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    @Override
    public String toString() {
        return "DtoCarrera{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                '}';
    }
}
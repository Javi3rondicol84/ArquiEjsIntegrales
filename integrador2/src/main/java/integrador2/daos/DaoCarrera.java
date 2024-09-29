package integrador2.daos;

import integrador2.dtos.DtoCarrera;
import integrador2.dtos.DtoCarreraCustom;
import integrador2.entities.Carrera;
import integrador2.entities.Estudiante;
import integrador2.entities.EstudianteCarrera;

import java.util.List;

public interface DaoCarrera {
    List<DtoCarrera> getAllCarrera();
    void deleteCarrera(int id);
    void insertCarrera(Carrera carrera);
    List<DtoCarrera> getCarrerasEstudiantesInscriptos();
    List<DtoCarreraCustom> getCarrerasInscriptosPorAnio();
    void addEstudiante(Carrera carrera,EstudianteCarrera estudiante);
}

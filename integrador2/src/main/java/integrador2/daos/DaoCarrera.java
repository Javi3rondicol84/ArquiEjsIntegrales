package integrador2.daos;

import integrador2.dtos.DtoCarrera;
import integrador2.entities.Carrera;

import java.util.List;

public interface DaoCarrera {
    List<DtoCarrera> getAllCarrera();
    void deleteCarrera(int id);
    void insertCarrera(Carrera carrera);
    List<DtoCarrera> getCarrerasEstudiantesInscriptos();
}

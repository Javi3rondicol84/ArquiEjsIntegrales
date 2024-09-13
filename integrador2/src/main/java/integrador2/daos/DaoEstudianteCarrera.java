package integrador2.daos;

import integrador2.dtos.DtoEstudianteCarrera;
import integrador2.entities.EstudianteCarrera;

import java.util.List;

public interface DaoEstudianteCarrera {
    List<DtoEstudianteCarrera> getAllEstudianteCarrera();
    void deleteEstudianteCarrera(int id);
    void insertEstudianteCarrera(EstudianteCarrera est);
}

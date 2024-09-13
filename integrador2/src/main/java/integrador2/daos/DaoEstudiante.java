package integrador2.daos;

import integrador2.dtos.DtoEstudiante;
import integrador2.entities.Estudiante;

import java.util.List;

public interface DaoEstudiante {
    List<DtoEstudiante> getAllEstudiante();
    void deleteEstudiante(int id);
    void insertEstudiante(Estudiante estudiante);
}

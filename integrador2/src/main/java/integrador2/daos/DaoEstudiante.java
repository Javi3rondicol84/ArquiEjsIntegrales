package integrador2.daos;

import integrador2.dtos.DtoEstudiante;
import integrador2.entities.Estudiante;

import java.util.List;

public interface DaoEstudiante {
    List<DtoEstudiante> getAllEstudiantesByName();
    void deleteEstudiante(int id);
    void insertEstudiante(Estudiante estudiante);
    DtoEstudiante getEstudianteNumeroLibreta(int numeroLibreta);
    List<DtoEstudiante> getAllEstudiantesByGender(String genero);
    List<DtoEstudiante> getAllEstudiantesByCarrera(String carrera, String ciudad);
}

package integrador3.repositories;

import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    @Query()
    DtoEstudiante insertStudent(Estudiante student);
    @Query()
    List<DtoEstudiante> getAllStudentsByName();
    @Query()
    List<DtoEstudiante> getStudentByNumber(int number);
    @Query()
    List<DtoEstudiante> getStudentByGender(String gender);
    @Query()
    List<DtoEstudiante> getStudentByCareerAndCity(String career, String city);
}


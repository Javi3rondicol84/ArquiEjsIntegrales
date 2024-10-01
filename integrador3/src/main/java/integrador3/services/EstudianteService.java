package integrador3.services;

import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Estudiante;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EstudianteService {

    DtoEstudiante insertStudent(Estudiante student);
    List<DtoEstudiante> getAllStudentsByName();
    List<DtoEstudiante> getStudentByNumber(int number);
    List<DtoEstudiante> getStudentByGender(String gender);
    List<DtoEstudiante> getStudentByCareerAndCity(String career,String city);
}

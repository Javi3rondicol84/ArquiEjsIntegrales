package integrador3.services;

import integrador3.dtos.DtoCarrera;
import integrador3.dtos.DtoCarreraCustom;
import integrador3.dtos.DtoEstudiante;
import integrador3.dtos.DtoEstudianteCarrera;
import integrador3.entities.Carrera;
import integrador3.entities.Estudiante;
import integrador3.entities.EstudianteCarrera;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface CarreraService {
    DtoEstudianteCarrera registerStudent(DtoEstudianteCarrera student);
    DtoCarrera insertCareer(Carrera career);
    List<DtoCarrera> getCareersWithStudents();
    List<DtoCarreraCustom> getReportCareer();
}

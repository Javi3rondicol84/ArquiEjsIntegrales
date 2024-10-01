package integrador3.services.servicesImpl;

import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Estudiante;
import integrador3.repositories.EstudianteRepository;
import integrador3.services.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private EstudianteRepository estudianteRepository;

    @Override
    public DtoEstudiante insertStudent(Estudiante student) {
        return estudianteRepository.insertStudent(student);
    }

    @Override
    public List<DtoEstudiante> getAllStudentsByName() {
        return estudianteRepository.getAllStudentsByName();
    }

    @Override
    public List<DtoEstudiante> getStudentByNumber(int number) {
        return estudianteRepository.getStudentByNumber(number);
    }

    @Override
    public List<DtoEstudiante> getStudentByGender(String gender) {
        return estudianteRepository.getStudentByGender(gender);
    }

    @Override
    public List<DtoEstudiante> getStudentByCareerAndCity(String career, String city) {
        return estudianteRepository.getStudentByCareerAndCity(career,city);
    }
}

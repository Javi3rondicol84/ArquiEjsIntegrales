package integrador3.services.servicesImpl;

import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Estudiante;
import integrador3.repositories.EstudianteRepository;
import integrador3.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public DtoEstudiante insertStudent(Estudiante student) {
        estudianteRepository.save(student);
        return new DtoEstudiante(student.getNombre(),student.getApellido(),student.getEdad(),student.getGenero(),student.getDni(),student.getCiudad(), student.getNumeroLibretaUniversitaria());
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
        gender = gender.toLowerCase();
        if(gender.equals("f") || gender.equals("m")){
            return estudianteRepository.getStudentByGender(gender);
        }else{
            return estudianteRepository.getStudentByGender("f");
        }
    }

    @Override
    public List<DtoEstudiante> getStudentByCareerAndCity(String career, String city) {
        return estudianteRepository.getStudentByCareerAndCity(career,city);
    }
}

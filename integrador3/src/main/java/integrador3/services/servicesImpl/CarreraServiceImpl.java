package integrador3.services.servicesImpl;

import integrador3.dtos.DtoCarrera;
import integrador3.dtos.DtoCarreraCustom;
import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Estudiante;
import integrador3.repositories.CarreraRepository;
import integrador3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public DtoEstudiante registerStudent(Estudiante student) {
        return carreraRepository.registerStudent(student);
    }

    @Override
    public List<DtoCarrera> getCareersWithStudents() {
        return carreraRepository.getCareersWithStudents();
    }

    @Override
    public List<DtoCarreraCustom> getReportCareer() {
        return carreraRepository.getReportCareer();
    }
}

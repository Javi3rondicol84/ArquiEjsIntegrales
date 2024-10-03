package integrador3.services.servicesImpl;

import integrador3.dtos.DtoCarrera;
import integrador3.dtos.DtoCarreraCustom;
import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Carrera;
import integrador3.entities.Estudiante;
import integrador3.repositories.CarreraRepository;
import integrador3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    //@Override
    //public DtoEstudiante registerStudent(Estudiante student) {
    //    return carreraRepository.registerStudent(student);
    //}

    @Override
    public List<DtoCarrera> getCareersWithStudents() {
        return carreraRepository.getCareersWithStudents();
    }

    public DtoCarrera insertCareer(Carrera career){
        carreraRepository.save(career);
        return new DtoCarrera(career.getNombreCarrera());
    }

    @Override
    public List<DtoCarreraCustom> getReportCareer() {
        List<Object[]> resultados = carreraRepository.getReportCareer();
        List<DtoCarreraCustom> carrerasCustom = new ArrayList<>();
        for (Object[] fila : resultados) {
            String nombreCarrera = (String) fila[0];
            // Cambia a Long y luego convierte a int si es necesario
            int inscriptos = ((Number) fila[1]).intValue();
            int anio = ((Number) fila[2]).intValue();
            int egresados = ((Number) fila[3]).intValue();

            carrerasCustom.add(new integrador3.dtos.DtoCarreraCustom(nombreCarrera, inscriptos, anio, egresados));
        }

        return carrerasCustom;
    }
}

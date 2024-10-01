package integrador3.repositories;

import integrador3.dtos.DtoCarrera;
import integrador3.dtos.DtoCarreraCustom;
import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Carrera;
import integrador3.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera,Long> {

    @Query()
    DtoEstudiante registerStudent(Estudiante student);
    @Query()
    List<DtoCarrera> getCareersWithStudents();
    @Query()
    List<DtoCarreraCustom> getReportCareer();

}

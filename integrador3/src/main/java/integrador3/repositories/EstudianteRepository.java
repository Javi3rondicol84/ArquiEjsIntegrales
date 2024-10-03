package integrador3.repositories;

import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    @Query("SELECT new integrador3.dtos.DtoEstudiante (e.nombre,e.apellido,e.edad,e.genero,e.dni,e.ciudad,e.numeroLibretaUniversitaria) FROM Estudiante e ORDER BY e.nombre")
    List<DtoEstudiante> getAllStudentsByName();
    @Query("SELECT new integrador3.dtos.DtoEstudiante (e.nombre,e.apellido,e.edad,e.genero,e.dni,e.ciudad,e.numeroLibretaUniversitaria) FROM Estudiante e WHERE e.numeroLibretaUniversitaria =:numeroLibreta")
    List<DtoEstudiante> getStudentByNumber(@Param("numeroLibreta") int number);
    @Query("SELECT new integrador3.dtos.DtoEstudiante (e.nombre,e.apellido,e.edad,e.genero,e.dni,e.ciudad,e.numeroLibretaUniversitaria) FROM Estudiante e WHERE e.genero =:genero")
    List<DtoEstudiante> getStudentByGender(@Param("genero") String gender);
    @Query("SELECT new integrador3.dtos.DtoEstudiante (e.nombre,e.apellido,e.edad,e.genero,e.dni,e.ciudad,e.numeroLibretaUniversitaria) FROM EstudianteCarrera ec JOIN ec.estudiante e JOIN ec.carreraInscripto c WHERE c.nombreCarrera =:carrera AND e.ciudad =:ciudad")
    List<DtoEstudiante> getStudentByCareerAndCity(@Param("carrera") String career, @Param("ciudad") String city);
}


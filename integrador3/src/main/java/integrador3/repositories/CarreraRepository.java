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

    //@Query()
    //DtoEstudiante registerStudent(Estudiante student);
    @Query("SELECT new integrador3.dtos.DtoCarrera (c.nombreCarrera) FROM EstudianteCarrera ec JOIN ec.carreraInscripto c WHERE ec.estudiante IS NOT NULL GROUP BY ec.carreraInscripto ORDER BY COUNT(ec.estudiante) DESC")
    List<DtoCarrera> getCareersWithStudents();
    @Query(value = "SELECT nombre_carrera, COUNT(ec.estudiante_id) AS inscriptos, YEAR(ec.fecha_inscripcion) AS anio, " +
            "(SELECT COUNT(ec1.estudiante_id) FROM carrera c1 " +
            "JOIN estudiante_carrera ec1 ON (c1.id_carrera = ec1.carrera_id) " +
            "WHERE ec1.graduado = 'si' " +
            "AND c1.id_carrera = c.id_carrera " +
            "AND YEAR(ec1.fecha_inscripcion) = YEAR(ec.fecha_inscripcion)) AS egresados " +
            "FROM carrera c " +
            "JOIN estudiante_carrera ec ON (c.id_carrera = ec.carrera_id) " +
            "GROUP BY YEAR(ec.fecha_inscripcion), c.nombre_carrera " +
            "ORDER BY c.nombre_carrera ASC, YEAR(ec.fecha_inscripcion) ASC",  nativeQuery = true)
    List<Object[]> getReportCareer();
}

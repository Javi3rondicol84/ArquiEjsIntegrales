package integrador2.daosImplementationMySQL;

import integrador2.daos.DaoCarrera;
import integrador2.dtos.DtoCarrera;
import integrador2.dtos.DtoCarreraCustom;
import integrador2.entities.Carrera;
import integrador2.entities.Estudiante;
import integrador2.entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DaoCarreraImplMySQL implements DaoCarrera {
    private EntityManager em;

    public DaoCarreraImplMySQL(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DtoCarrera> getAllCarrera() {
        List<DtoCarrera> dtoCarreras = em.createQuery("select new integrador2.dtos.DtoCarrera (c.nombreCarrera) from Carrera c", DtoCarrera.class).getResultList();
        return dtoCarreras;
    }

    @Override
    public void deleteCarrera(int id) {
        em.getTransaction().begin();
        Carrera carrera = em.find(Carrera.class, id);
        em.remove(carrera);
        em.getTransaction().commit();
    }

    @Override
    public void insertCarrera(Carrera carrera) {
        em.getTransaction().begin();
        em.persist(carrera);
        em.getTransaction().commit();
    }

    @Override
    public List<DtoCarrera> getCarrerasEstudiantesInscriptos() {
        String query = "SELECT new integrador2.dtos.DtoCarrera (c.nombreCarrera) FROM EstudianteCarrera ec JOIN ec.carreraInscripto c WHERE ec.estudiante IS NOT NULL GROUP BY ec.carreraInscripto ORDER BY COUNT(ec.estudiante) DESC";
        List<DtoCarrera> dtoCarreras = em.createQuery(query, DtoCarrera.class).getResultList();
        return dtoCarreras;
    }

    /*Generar un reporte de las carreras, que para cada carrera incluya información de los
    inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
    los años de manera cronológica.*/

    public List<DtoCarreraCustom> getCarrerasInscriptosPorAnio(){
        String query = "SELECT nombreCarrera, COUNT(ec.estudiante_id) AS inscriptos, YEAR(ec.fechaInscripcion) AS anio, " +
                "(SELECT COUNT(ec1.estudiante_id) FROM carrera c1 " +
                "JOIN estudiantecarrera ec1 ON (c1.idCarrera = ec1.carrera_id) " +
                "WHERE ec1.graduado = 'si' " +
                "AND c1.idCarrera = c.idCarrera " +
                "AND YEAR(ec1.fechaInscripcion) = YEAR(ec.fechaInscripcion)) AS egresados " +
                "FROM carrera c " +
                "JOIN estudiantecarrera ec ON (c.idCarrera = ec.carrera_id) " +
                "GROUP BY YEAR(ec.fechaInscripcion), c.nombreCarrera " +
                "ORDER BY c.nombreCarrera ASC, YEAR(ec.fechaInscripcion) ASC";
        List<Object[]> resultados = em.createNativeQuery(query).getResultList();
        List<DtoCarreraCustom> carrerasCustom = new ArrayList<>();
        for (Object[] fila : resultados) {
            String nombreCarrera = (String) fila[0];
            int inscriptos = (fila[1] instanceof BigInteger) ? ((BigInteger) fila[1]).intValue() : (Integer) fila[1];
            int anio = (fila[2] instanceof BigInteger) ? ((BigInteger) fila[2]).intValue() : (Integer) fila[2];
            int egresados = (fila[3] instanceof BigInteger) ? ((BigInteger) fila[3]).intValue() : (Integer) fila[3];

            carrerasCustom.add(new DtoCarreraCustom(nombreCarrera, inscriptos, anio, egresados));
        }

        return carrerasCustom;
    }

    @Override
    public void addEstudiante(Carrera carrera,EstudianteCarrera estudiante) {
        carrera.addEstudiante(estudiante);
    }


}

package integrador2.daosImplementationMySQL;

import integrador2.daos.DaoCarrera;
import integrador2.dtos.DtoCarrera;
import integrador2.dtos.DtoCarreraCustom;
import integrador2.entities.Carrera;
import integrador2.entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        String query = "SELECT new integrador2.dtos.DtoCarreraCustom(c.nombreCarrera, e.nombre,e.apellido, e.edad, YEAR(ec.antiguedadCarrera)) FROM EstudianteCarrera ec JOIN ec.carreraInscripto c JOIN ec.estudiante e WHERE ec.graduado LIKE 'si' ORDER BY YEAR (ec.antiguedadCarrera), c.nombreCarrera";
        List<DtoCarreraCustom> algo = em.createQuery(query, DtoCarreraCustom.class).getResultList();
        return algo;
    }
}

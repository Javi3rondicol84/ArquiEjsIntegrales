package integrador2.daosImplementationMySQL;

import integrador2.daos.DaoEstudiante;
import integrador2.dtos.DtoEstudiante;
import integrador2.entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class DaoEstudianteImplMySQL implements DaoEstudiante {
    private EntityManager em;

    public DaoEstudianteImplMySQL(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DtoEstudiante> getAllEstudiantesByName() {
        List<DtoEstudiante> dtoEstudiantes = em.createQuery("SELECT new integrador2.dtos.DtoEstudiante (e.nombre,e.apellido,e.edad,e.genero,e.dni,e.ciudad,e.numeroLibretaUniversitaria) FROM Estudiante e ORDER BY e.nombre DESC", DtoEstudiante.class).getResultList();
        return dtoEstudiantes;
    }

    public List<DtoEstudiante> getAllEstudiantesByGender(String genero) {
        TypedQuery<DtoEstudiante> query = em.createQuery("SELECT new integrador2.dtos.DtoEstudiante (e.nombre,e.apellido,e.edad,e.genero,e.dni,e.ciudad,e.numeroLibretaUniversitaria) FROM Estudiante e WHERE e.genero =: genero", DtoEstudiante.class);
        query.setParameter("genero", genero);
        List<DtoEstudiante> dtoEstudiantes = query.getResultList();
        return dtoEstudiantes;
    }

    @Override
    public List<DtoEstudiante> getAllEstudiantesByCarrera(String carrera, String ciudad) {
        String query = "SELECT new integrador2.dtos.DtoEstudiante (e.nombre,e.apellido,e.edad,e.genero,e.dni,e.ciudad,e.numeroLibretaUniversitaria) FROM EstudianteCarrera ec JOIN ec.estudiante e JOIN ec.carreraInscripto c WHERE c.nombreCarrera =: carrera AND e.ciudad =: ciudad";
        TypedQuery<DtoEstudiante> typedQuery = em.createQuery(query, DtoEstudiante.class);
        typedQuery.setParameter("carrera", carrera);
        typedQuery.setParameter("ciudad", ciudad);
        List<DtoEstudiante> dtoEstudiantes = typedQuery.getResultList();
        return dtoEstudiantes;
    }

    @Override
    public void deleteEstudiante(int id) {
        em.getTransaction().begin();
        Estudiante estudiante = em.find(Estudiante.class, id);
        em.remove(estudiante);
        em.getTransaction().commit();
    }

    @Override
    public void insertEstudiante(Estudiante estudiante) {
        em.getTransaction().begin();
        em.persist(estudiante);
        em.getTransaction().commit();
    }

    @Override
    public DtoEstudiante getEstudianteNumeroLibreta(int numeroLibreta) {
        TypedQuery<DtoEstudiante> query = em.createQuery("SELECT new integrador2.dtos.DtoEstudiante (e.nombre,e.apellido,e.edad,e.genero,e.dni,e.ciudad,e.numeroLibretaUniversitaria) FROM Estudiante e WHERE e.numeroLibretaUniversitaria =:numeroLibreta", DtoEstudiante.class);
        query.setParameter("numeroLibreta", numeroLibreta);
        DtoEstudiante dtoEstudiante = query.getSingleResult();
        return dtoEstudiante;
    }
}

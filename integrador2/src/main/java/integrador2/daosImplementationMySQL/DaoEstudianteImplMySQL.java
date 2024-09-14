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
        List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.nombre DESC").getResultList();
        List<DtoEstudiante> dtoEstudiantes = new ArrayList<DtoEstudiante>();
        for(Estudiante estudiante : estudiantes) {
            DtoEstudiante dtoEstudiante = new DtoEstudiante(estudiante.getNombre(),estudiante.getApellido(),estudiante.getEdad(),estudiante.getGenero(),estudiante.getDni(),estudiante.getCiudad(),estudiante.getNumeroLibretaUniversitaria());
            dtoEstudiantes.add(dtoEstudiante);
        }
        return dtoEstudiantes;
    }

    public List<DtoEstudiante> getAllEstudiantesByGender(String genero) {
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero =: genero", Estudiante.class);
        query.setParameter("genero", genero);
        List<Estudiante> estudiantes = query.getResultList();
        List<DtoEstudiante> dtoEstudiantes = new ArrayList<DtoEstudiante>();
        for(Estudiante estudiante : estudiantes) {
            DtoEstudiante dtoEstudiante = new DtoEstudiante(estudiante.getNombre(),estudiante.getApellido(),estudiante.getEdad(),estudiante.getGenero(),estudiante.getDni(),estudiante.getCiudad(),estudiante.getNumeroLibretaUniversitaria());
            dtoEstudiantes.add(dtoEstudiante);
        }
        return dtoEstudiantes;
    }

    @Override
    public List<DtoEstudiante> getAllEstudiantesByCarrera(String carrera, String ciudad) {
        String query = "SELECT e FROM EstudianteCarrera ec JOIN ec.estudiante e JOIN ec.carreraInscripto c WHERE c.nombreCarrera =: carrera AND e.ciudad =: ciudad";
        TypedQuery<Estudiante> typedQuery = em.createQuery(query, Estudiante.class);
        typedQuery.setParameter("carrera", carrera);
        typedQuery.setParameter("ciudad", ciudad);
        List<Estudiante> estudiantes = typedQuery.getResultList();
        List<DtoEstudiante> dtoEstudiantes = new ArrayList<>();
        for(Estudiante estudiante : estudiantes) {
            DtoEstudiante dtoEstudiante = new DtoEstudiante(estudiante.getNombre(),estudiante.getApellido(),estudiante.getEdad(),estudiante.getGenero(),estudiante.getDni(),estudiante.getCiudad(),estudiante.getNumeroLibretaUniversitaria());
            dtoEstudiantes.add(dtoEstudiante);
        }
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
        TypedQuery<Estudiante> query = em.createQuery("SELECT e FROM Estudiante e WHERE e.numeroLibretaUniversitaria =:numeroLibreta", Estudiante.class);
        query.setParameter("numeroLibreta", numeroLibreta);
        Estudiante estudiante = query.getSingleResult();
        DtoEstudiante dtoEstudiante = new DtoEstudiante(estudiante.getNombre(),estudiante.getApellido(),estudiante.getEdad(),estudiante.getGenero(),estudiante.getDni(),estudiante.getCiudad(),estudiante.getNumeroLibretaUniversitaria());
        return dtoEstudiante;
    }
}

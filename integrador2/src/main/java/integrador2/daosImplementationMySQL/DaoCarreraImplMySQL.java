package integrador2.daosImplementationMySQL;

import integrador2.daos.DaoCarrera;
import integrador2.dtos.DtoCarrera;
import integrador2.entities.Carrera;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class DaoCarreraImplMySQL implements DaoCarrera {
    private EntityManager em;

    public DaoCarreraImplMySQL(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DtoCarrera> getAllCarrera() {
        List<Carrera> carreras = em.createQuery("select c from Carrera c", Carrera.class).getResultList();
        List<DtoCarrera> dtoCarreras = new ArrayList<>();
        for (Carrera c : carreras) {
            DtoCarrera dtoCarrera = new DtoCarrera(c.getNombreCarrera());
            dtoCarreras.add(dtoCarrera);
        }
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
        String query = "SELECT c FROM EstudianteCarrera ec JOIN ec.carreraInscripto c WHERE ec.estudiante IS NOT NULL GROUP BY ec.carreraInscripto ORDER BY COUNT(ec.estudiante) DESC";
        List<Carrera> carreras = em.createQuery(query, Carrera.class).getResultList();
        List<DtoCarrera> dtoCarreras = new ArrayList<>();
        for(Carrera c : carreras) {
            DtoCarrera dtoCarrera =  new DtoCarrera(c.getNombreCarrera());
            dtoCarreras.add(dtoCarrera);
        }
        return dtoCarreras;
    }
}

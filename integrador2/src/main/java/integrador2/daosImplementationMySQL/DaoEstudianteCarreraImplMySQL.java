package integrador2.daosImplementationMySQL;

import integrador2.daos.DaoEstudianteCarrera;
import integrador2.entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoEstudianteCarreraImplMySQL implements DaoEstudianteCarrera {
    private EntityManager em;

    public DaoEstudianteCarreraImplMySQL(EntityManager em) {
        this.em = em;
    }


    @Override
    public void deleteEstudianteCarrera(int id) {
        em.getTransaction().begin();
        EstudianteCarrera estudianteCarrera = em.find(EstudianteCarrera.class, id);
        em.remove(estudianteCarrera);
        em.getTransaction().commit();
    }

    @Override
    public void insertEstudianteCarrera(EstudianteCarrera estudianteCarrera) {
        em.getTransaction().begin();
        em.persist(estudianteCarrera);
        em.getTransaction().commit();
    }
}

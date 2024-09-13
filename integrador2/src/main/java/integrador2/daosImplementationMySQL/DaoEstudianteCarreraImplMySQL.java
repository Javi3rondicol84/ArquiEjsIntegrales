package integrador2.daosImplementationMySQL;

import integrador2.daos.DaoEstudianteCarrera;
import integrador2.dtos.DtoEstudianteCarrera;
import integrador2.entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoEstudianteCarreraImplMySQL implements DaoEstudianteCarrera {
    private EntityManager em;

    public DaoEstudianteCarreraImplMySQL(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<DtoEstudianteCarrera> getAllEstudianteCarrera() {
        return List.of();
    }

    @Override
    public void deleteEstudianteCarrera(int id) {

    }

    @Override
    public void insertEstudianteCarrera(EstudianteCarrera est) {

    }
}

package integrador2.daosImplementationMySQL;

import integrador2.daos.DaoEstudiante;
import integrador2.dtos.DtoEstudiante;
import integrador2.entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class DaoEstudianteImplMySQL implements DaoEstudiante {
    private EntityManager em;

    public DaoEstudianteImplMySQL(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<DtoEstudiante> getAllEstudiante() {
        return List.of();
    }

    @Override
    public void deleteEstudiante(int id) {

    }

    @Override
    public void insertEstudiante(Estudiante estudiante) {

    }
}

package integrador2.factories;

import integrador2.daos.DaoCarrera;
import integrador2.daos.DaoEstudiante;
import integrador2.daos.DaoEstudianteCarrera;
import integrador2.daosImplementationMySQL.DaoCarreraImplMySQL;
import integrador2.daosImplementationMySQL.DaoEstudianteCarreraImplMySQL;
import integrador2.daosImplementationMySQL.DaoEstudianteImplMySQL;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryMySQL extends Factory {
    public static FactoryMySQL instance = null;


    @Override
    public DaoEstudiante getDaoEstudiante() {
        return new DaoEstudianteImplMySQL(getEntityManagerFactory().createEntityManager());
    }

    @Override
    public DaoCarrera getDaoCarrera() {
        return new DaoCarreraImplMySQL(getEntityManagerFactory().createEntityManager());
    }

    @Override
    public DaoEstudianteCarrera getDaoEstudianteCarrera() {
        return new DaoEstudianteCarreraImplMySQL(getEntityManagerFactory().createEntityManager());
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("MySQL");
    }

    public static synchronized FactoryMySQL getInstance(){
        if(instance == null){
            instance = new FactoryMySQL();
        }
        return instance;
    }
}

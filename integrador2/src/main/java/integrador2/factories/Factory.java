package integrador2.factories;

import integrador2.daos.DaoCarrera;
import integrador2.daos.DaoEstudiante;
import integrador2.daos.DaoEstudianteCarrera;

import javax.persistence.EntityManagerFactory;

public abstract class Factory {
    public abstract DaoEstudiante getDaoEstudiante();
    public abstract DaoCarrera getDaoCarrera();
    public abstract DaoEstudianteCarrera getDaoEstudianteCarrera();
    protected abstract EntityManagerFactory getEntityManagerFactory();

    public static Factory getFactory(String bd){
        switch(bd) {
            case("MySQL") : {
                return FactoryMySQL.getInstance();
            }
            default : {
                return null;
            }
        }
    }
}

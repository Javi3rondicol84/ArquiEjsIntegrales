package integrador2.Main;

import integrador2.daos.DaoCarrera;
import integrador2.daos.DaoEstudiante;
import integrador2.daos.DaoEstudianteCarrera;
import integrador2.entities.Carrera;
import integrador2.entities.Estudiante;
import integrador2.entities.EstudianteCarrera;
import integrador2.factories.Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Estudiante e1 = new Estudiante("juan", "perez",22,"m",6724606,"tandil",529373);
        Estudiante e2 = new Estudiante("juana2", "perez1",24,"f",67222606,"azul",529875);
        Estudiante e3 = new Estudiante("juan3", "perez2",29,"m",672846706,"tandil",529773);
        Carrera c1 = new Carrera("tudai");
        Carrera c2 = new Carrera("historia");
        Carrera c3 = new Carrera("geografia");
        EstudianteCarrera ec1 = new EstudianteCarrera(c1, LocalDate.now(),"no",e1);
        EstudianteCarrera ec2 = new EstudianteCarrera(c2,LocalDate.now(),"no",e1);
        EstudianteCarrera ec3 = new EstudianteCarrera(c2,LocalDate.now(),"no",e2);
        EstudianteCarrera ec4 = new EstudianteCarrera(c2,LocalDate.now(),"no",e3);
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(ec1);
        em.persist(ec2);
        em.persist(ec3);
        em.persist(ec4);
        /*Factory factory = Factory.getFactory("MySQL");
        DaoCarrera daoCarrera = factory.getDaoCarrera();
        DaoEstudiante daoEstudiante = factory.getDaoEstudiante();
        DaoEstudianteCarrera daoEstudianteCarrera = factory.getDaoEstudianteCarrera();
        System.out.println(daoCarrera.getCarrerasInscriptosPorAnio());*/
        em.getTransaction().commit();
        em.close();
    }
}

package integrador2.Main;

import integrador2.entities.Carrera;
import integrador2.entities.Estudiante;
import integrador2.entities.EstudianteCarrera;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("integrador2");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Estudiante e1 = new Estudiante("juan", "perez",22,"m",67284606,"tandil",529873);
        Carrera c1 = new Carrera("tudai");
        Carrera c2 = new Carrera("historia");
        EstudianteCarrera ec1 = new EstudianteCarrera(c1,"3 meses","no",e1);
        EstudianteCarrera ec2 = new EstudianteCarrera(c2,"7 meses","no",e1);
        em.persist(e1);
        em.persist(c1);
        em.persist(c2);
        em.persist(ec1);
        em.persist(ec2);
        em.getTransaction().commit();
        em.close();
    }
}

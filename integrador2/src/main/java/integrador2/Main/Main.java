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
        Estudiante e4 = new Estudiante("salvador", "algo",49,"m",672888706,"mar del plata",563973);
        Estudiante e5 = new Estudiante("andres", "asi",19,"m",649946706,"mar del plata",789773);
        Carrera c1 = new Carrera("tudai");
        Carrera c2 = new Carrera("historia");
        Carrera c3 = new Carrera("geografia");
        Carrera c4 = new Carrera("psicologia");
        EstudianteCarrera ec1 = new EstudianteCarrera(c1, LocalDate.now(),"no",e1,LocalDate.of(2023,8,20));
        EstudianteCarrera ec2 = new EstudianteCarrera(c2,LocalDate.now(),"no",e1,LocalDate.of(2023,9,24));
        EstudianteCarrera ec3 = new EstudianteCarrera(c2,LocalDate.now(),"si",e2,LocalDate.of(2024,8,10));
        EstudianteCarrera ec4 = new EstudianteCarrera(c2,LocalDate.now(),"no",e3,LocalDate.of(2023,4,29));
        EstudianteCarrera ec5 = new EstudianteCarrera(c4,LocalDate.now(),"si",e4,LocalDate.of(2021,2,11));
        EstudianteCarrera ec6 = new EstudianteCarrera(c4,LocalDate.now(),"no",e5,LocalDate.of(2024,7,30));
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);
        em.persist(e5);
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);
        em.persist(c4);
        em.persist(ec1);
        em.persist(ec2);
        em.persist(ec3);
        em.persist(ec4);
        em.persist(ec5);
        em.persist(ec6);
        Estudiante estudiante = new Estudiante("andres","montero",20,"m",466747290,"olavarria",25143768);
        Factory factory = Factory.getFactory("MySQL");
        DaoCarrera daoCarrera = factory.getDaoCarrera();
        DaoEstudiante daoEstudiante = factory.getDaoEstudiante();
        //dar de alta a un estudiante
        //daoEstudiante.insertEstudiante(estudiante);
        Carrera carrera = em.find(Carrera.class,38);
        Estudiante e = em.find(Estudiante.class,34);
        //matricular un estudiante en una carrera
        //daoCarrera.addEstudiante(carrera, new EstudianteCarrera(carrera,LocalDate.now(),"no",e,LocalDate.of(2024,6,17)));

        //recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
        //System.out.println(daoEstudiante.getAllEstudiantesByName());

        //recuperar un estudiante, en base a su número de libreta universitaria
        //System.out.println(daoEstudiante.getEstudianteNumeroLibreta(25143768));

        //recuperar todos los estudiantes, en base a su género.(f o m)
        //System.out.println(daoEstudiante.getAllEstudiantesByGender("f"));

        //recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        //System.out.println(daoCarrera.getCarrerasEstudiantesInscriptos());

        //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
        //System.out.println(daoEstudiante.getAllEstudiantesByCarrera("historia","tandil"));

        //Generar un reporte de las carreras, que para cada carrera incluya información de los
        //inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        //los años de manera cronológica.
        //System.out.println(daoCarrera.getCarrerasInscriptosPorAnio());
        em.getTransaction().commit();
        em.close();
    }
}

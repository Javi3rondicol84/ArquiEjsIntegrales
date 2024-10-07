package integrador3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Integrador3Application {
    /* JSON valido para el metodo registerStudent en Carrera
    * {
    "carreraId": 2,
    "antiguedadCarrera": "2004-05-17",
    "graduado": "si",
    "fechaInscripcion": "2000-04-17",
    "estudianteId": 1
    }*/
    public static void main(String[] args) {
        SpringApplication.run(Integrador3Application.class, args);
    }

}

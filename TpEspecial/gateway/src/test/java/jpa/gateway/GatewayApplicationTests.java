package jpa.gateway;


import jpa.gateway.auth.SolicitudRegistro;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GatewayApplicationTests {

    @Test
    public void contextLoads() {
        // Test context loading
    }

    @Test
    public void testRolValido() {
        // Roles válidos
        String rolAdmin = "ADMINISTRADOR";
        String rolMantenimiento = "MANTENIMIENTO";

        // Crea instancias de SolicitudRegistro
        SolicitudRegistro solicitud1 = new SolicitudRegistro();
        SolicitudRegistro solicitud2 = new SolicitudRegistro();
        SolicitudRegistro solicitud3 = new SolicitudRegistro();

        // Setea roles válidos
        solicitud1.setRol("administrador");
        solicitud2.setRol("MANTENIMIENTO");

        // Setea un rol inválido
        solicitud3.setRol("invitado");

        // Comprueba que los roles son válidos
        Assertions.assertEquals(solicitud1.getRol(), rolAdmin, "se esperaba ADMINISTARDOR");
        Assertions.assertEquals(solicitud2.getRol(), rolMantenimiento, "se esperaba MANTENIMIENTO");

        // Comprueba que un rol inválido no es igual a los válidos
        Assertions.assertEquals(solicitud3.getRol(), rolAdmin, "El rol debería ser ADMINISTRADOR");
    }
}

package tpespecial.administradorms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AdministradormsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdministradormsApplication.class, args);
    }

}

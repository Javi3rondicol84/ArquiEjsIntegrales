package jpa.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/holamundo")
    public String holaMundo(){
        return "Hola Mundo";
    }

    @GetMapping("/chaumundo")
    public String chaumundo(){
        return "Chau Mundo";
    }
}

package jpa.gateway.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/administrador/**", method = RequestMethod.GET)
    public ResponseEntity<String> dirigirAdministrador(HttpServletRequest request) {
        String url= "http://localhost:8001"+ request.getRequestURI();
        return restTemplate.getForEntity(url, String.class);
    }

    @RequestMapping(value = "/mantenimiento/**", method = RequestMethod.GET)
    public ResponseEntity<String> dirigirMantenimiento(HttpServletRequest request) {
        String url= "http://localhost:8001"+ request.getRequestURI();
        return restTemplate.getForEntity(url, String.class);
    }

    @RequestMapping(value = "/monopatin/**", method = RequestMethod.GET)
    public ResponseEntity<String> dirigirMonopatin(HttpServletRequest request) {
        String url= "http://localhost:8002"+ request.getRequestURI();
        return restTemplate.getForEntity(url, String.class);
    }

    @RequestMapping(value = "/parada/**", method = RequestMethod.GET)
    public ResponseEntity<String> dirigirParada(HttpServletRequest request) {
        String url= "http://localhost:8003"+ request.getRequestURI();
        return restTemplate.getForEntity(url, String.class);
    }

    @RequestMapping(value = "/viaje/**", method = RequestMethod.GET)
    public ResponseEntity<String> dirigirViaje(HttpServletRequest request) {
        String url= "http://localhost:8004"+ request.getRequestURI();
        return restTemplate.getForEntity(url, String.class);
    }

    @RequestMapping(value = "/usuario/**", method = RequestMethod.GET)
    public ResponseEntity<String> dirigirUsuario(HttpServletRequest request) {
        String url= "http://localhost:8005"+ request.getRequestURI();
        return restTemplate.getForEntity(url, String.class);
    }

    @RequestMapping(value = "/cuenta/**", method = RequestMethod.GET)
    public ResponseEntity<String> dirigirCuenta(HttpServletRequest request) {
        String url= "http://localhost:8005"+ request.getRequestURI();
        return restTemplate.getForEntity(url, String.class);
    }

    @RequestMapping(value = "/administrador/**", method = RequestMethod.POST)
    public ResponseEntity<String> postDirigirAdministrador(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8001"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url, entity, String.class);
    }

    @RequestMapping(value = "/mantenimiento/**", method = RequestMethod.POST)
    public ResponseEntity<String> postDirigirMantenimiento(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8001"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url, entity, String.class);
    }

    @RequestMapping(value = "/monopatin/**", method = RequestMethod.POST)
    public ResponseEntity<String> postDirigirMonopatin(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8002"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url, entity, String.class);
    }

    @RequestMapping(value = "/parada/**", method = RequestMethod.POST)
    public ResponseEntity<String> postDirigirParada(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8003"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url, entity, String.class);
    }

    @RequestMapping(value = "/viaje/**", method = RequestMethod.POST)
    public ResponseEntity<String> postDirigirViaje(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8004"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url, entity, String.class);
    }

    @RequestMapping(value = "/usuario/**", method = RequestMethod.POST)
    public ResponseEntity<String> postDirigirUsuario(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8005"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url, entity, String.class);
    }

    @RequestMapping(value = "/cuenta/**", method = RequestMethod.POST)
    public ResponseEntity<String> postDirigirCuenta(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8005"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(url, entity, String.class);
    }

    @RequestMapping(value = "/administrador/**", method = RequestMethod.PUT)
    public ResponseEntity<String> putDirigirAdministrador(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8001"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
    }

    @RequestMapping(value = "/mantenimiento/**", method = RequestMethod.PUT)
    public ResponseEntity<String> putDirigirMantenimiento(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8001"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
    }

    @RequestMapping(value = "/monopatin/**", method = RequestMethod.PUT)
    public ResponseEntity<String> putDirigirMonopatin(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8002"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
    }

    @RequestMapping(value = "/parada/**", method = RequestMethod.PUT)
    public ResponseEntity<String> putDirigirParada(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8003"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
    }

    @RequestMapping(value = "/viaje/**", method = RequestMethod.PUT)
    public ResponseEntity<String> putDirigirViaje(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8004"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
    }

    @RequestMapping(value = "/usuario/**", method = RequestMethod.PUT)
    public ResponseEntity<String> putDirigirUsuario(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8005"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
    }

    @RequestMapping(value = "/cuenta/**", method = RequestMethod.PUT)
    public ResponseEntity<String> putDirigirCuenta(HttpServletRequest request, @RequestBody String body) {
        String url= "http://localhost:8005"+ request.getRequestURI();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
    }

    @RequestMapping(value = "/administrador/**", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDirigirAdministrador(HttpServletRequest request) {
        String url = "http://localhost:8001" + request.getRequestURI();
        return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }

    @RequestMapping(value = "/mantenimiento/**", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDirigirMantenimiento(HttpServletRequest request) {
        String url = "http://localhost:8001" + request.getRequestURI();
        return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }

    @RequestMapping(value = "/monopatin/**", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDirigirMonopatin(HttpServletRequest request) {
        String url = "http://localhost:8002" + request.getRequestURI();
        return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }

    @RequestMapping(value = "/parada/**", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDirigirParada(HttpServletRequest request) {
        String url = "http://localhost:8003" + request.getRequestURI();
        return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }

    @RequestMapping(value = "/viaje/**", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDirigirViaje(HttpServletRequest request) {
        String url = "http://localhost:8004" + request.getRequestURI();
        return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }

    @RequestMapping(value = "/usuario/**", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDirigirUsuario(HttpServletRequest request) {
        String url = "http://localhost:8005" + request.getRequestURI();
        return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }

    @RequestMapping(value = "/cuenta/**", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteDirigirCuenta(HttpServletRequest request) {
        String url = "http://localhost:8005" + request.getRequestURI();
        return restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }







}

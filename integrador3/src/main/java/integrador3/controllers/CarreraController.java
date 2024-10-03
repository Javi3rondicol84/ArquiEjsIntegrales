package integrador3.controllers;

import integrador3.dtos.DtoCarrera;
import integrador3.dtos.DtoCarreraCustom;
import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Carrera;
import integrador3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import integrador3.entities.Estudiante;

import java.util.List;

@RestController
@RequestMapping("/career")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    //@PostMapping("/registerstudent")
    //public DtoEstudiante registerStudent(@RequestBody Estudiante student){
     //   return carreraService.registerStudent(student);
    //}

    @PostMapping("/insert")
    public DtoCarrera insertCareer(@RequestBody Carrera career){
        return carreraService.insertCareer(career);
    }

    @GetMapping("/getcareerswithstudents")
    public List<DtoCarrera> getCareersWithStudents(){
        return carreraService.getCareersWithStudents();
    }

    @GetMapping("/getreportcareer")
    public List<DtoCarreraCustom> getReportCareer(){
        return carreraService.getReportCareer();
    }





}

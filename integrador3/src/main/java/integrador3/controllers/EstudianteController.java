package integrador3.controllers;

import integrador3.dtos.DtoEstudiante;
import integrador3.entities.Carrera;
import integrador3.entities.Estudiante;
import integrador3.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/insert")
    public DtoEstudiante insertStudent(@RequestBody Estudiante student){
        return estudianteService.insertStudent(student);
    }

    @GetMapping("/getallbyname")
    public List<DtoEstudiante> getAllStudentsByName(){
        return estudianteService.getAllStudentsByName();
    }

    @GetMapping("/getbynumber/{number}")
    public List<DtoEstudiante> getStudentByNumber(@PathVariable int number){
       return estudianteService.getStudentByNumber(number);
    }

    @GetMapping("/getbygender/{gender}")
    public List<DtoEstudiante> getStudentByGender(@PathVariable String gender){
        return estudianteService.getStudentByGender(gender);
    }

    @GetMapping("/getbycareerandcity/{career}/{city}")
    public List<DtoEstudiante> getStudentByCareerAndCity(@PathVariable String career, @PathVariable String city){
        return estudianteService.getStudentByCareerAndCity(career,city);
    }



}

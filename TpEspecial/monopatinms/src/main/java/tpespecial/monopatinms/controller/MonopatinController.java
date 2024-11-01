package tpespecial.monopatinms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.monopatinms.dto.MonopatinDto;
import tpespecial.monopatinms.service.MonopatinService;

import java.util.List;

@RestController
@RequestMapping("/monopatin")
public class MonopatinController {
    @Autowired
    private MonopatinService monopatinService;

    @GetMapping("")
    public List<MonopatinDto> getAllCuentas() {
        return monopatinService.getAll();
    }

    @GetMapping("/{id}")
    public MonopatinDto getCuentasById(@PathVariable Long id) {
        return monopatinService.getById(id);
    }

    @PostMapping("/add")
    public MonopatinDto createCuenta(@RequestBody MonopatinDto cuenta) {
        return monopatinService.create(cuenta);
    }

    @PutMapping("/update/{id}")
    public MonopatinDto updateCuenta(@PathVariable Long id, @RequestBody MonopatinDto cuenta) {
        return monopatinService.update(id, cuenta);
    }

    @DeleteMapping("/delete/{id}")
    public MonopatinDto deleteCuenta(@PathVariable Long id) {
        return monopatinService.delete(id);
    }

    @PutMapping("/mantenimiento/{id}")
    public MonopatinDto mantenimiento(@RequestBody boolean habilitado,@PathVariable Long id) {
        return monopatinService.mantenimiento(habilitado,id);
    }

    @PutMapping("/agregarenparada/{id}")
    public MonopatinDto agregarEnParada(@RequestBody String gps, @PathVariable Long id){
        return monopatinService.agregarEnParada(gps,id);
    }

}

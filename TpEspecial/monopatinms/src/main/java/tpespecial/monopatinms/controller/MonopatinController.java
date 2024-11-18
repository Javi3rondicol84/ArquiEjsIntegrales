package tpespecial.monopatinms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.monopatinms.dto.CantidadMonopatinesDto;
import tpespecial.monopatinms.dto.MonopatinDto;
import tpespecial.monopatinms.service.MonopatinService;

import java.util.List;

@RestController
@RequestMapping("/monopatin")
public class MonopatinController {
    @Autowired
    private MonopatinService monopatinService;


    @DeleteMapping("/borrartodo")
    public void deleteAllMonopatines() {
        monopatinService.deleteAllMonopatines();
    }

    @GetMapping("")
    public List<MonopatinDto> getAll() {
        return monopatinService.getAll();
    }

    @GetMapping("/{id}")
    public MonopatinDto getById(@PathVariable String id) {
        return monopatinService.getById(id);
    }

    @PostMapping("/add")
    public MonopatinDto create(@RequestBody MonopatinDto cuenta) {
        return monopatinService.create(cuenta);
    }

    @PutMapping("/update/{id}")
    public MonopatinDto update(@PathVariable String id, @RequestBody MonopatinDto cuenta) {
        return monopatinService.update(id, cuenta);
    }

    @DeleteMapping("/delete/{id}")
    public MonopatinDto delete(@PathVariable String id) {
        return monopatinService.delete(id);
    }

    @PutMapping("/mantenimiento/{id}")
    public MonopatinDto mantenimiento(@RequestBody boolean habilitado,@PathVariable String id) {
        return monopatinService.mantenimiento(habilitado,id);
    }

    @GetMapping("/mantenimientovsoperacion")
    CantidadMonopatinesDto monopatinesMantenimientoVsOperacion(){
        return monopatinService.monopatinesMantenimientoVsOperacion();
    }

    @GetMapping("/monopatinescercanos/{ubicacion}")
    List<MonopatinDto> monopatinesCercanos(@PathVariable String ubicacion){
        return monopatinService.monopatinesCercanos(ubicacion);
    }

}

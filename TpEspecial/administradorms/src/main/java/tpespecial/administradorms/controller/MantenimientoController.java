package tpespecial.administradorms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.administradorms.dto.MantenimientoDto;
import tpespecial.administradorms.service.MantenimientoService;

import java.util.List;

@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoController {
    @Autowired
    MantenimientoService mantenimientoService;

    @GetMapping("")
    List<MantenimientoDto> getAllMantenimiento() {
        return mantenimientoService.getAllMantenimiento();
    }

    @GetMapping("/{id}")
    MantenimientoDto getMantenimientoById(@PathVariable Long id) {
        return mantenimientoService.getMantenimientoById(id);
    }

    @PostMapping("/add")
    MantenimientoDto addMantenimiento(@RequestBody MantenimientoDto mantenimientoDto) {
        return mantenimientoService.add(mantenimientoDto);
    }

    @PutMapping("/update/{id}")
    MantenimientoDto updateMantenimiento(@PathVariable Long id, @RequestBody MantenimientoDto mantenimientoDto) {
        return mantenimientoService.update(id, mantenimientoDto);
    }

    @DeleteMapping("/delete/{id}")
    MantenimientoDto deleteMantenimiento(@PathVariable Long id) {
        return mantenimientoService.delete(id);
    }

}

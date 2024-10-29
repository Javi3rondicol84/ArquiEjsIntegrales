package tpespecial.paradams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.paradams.dto.ParadaDto;
import tpespecial.paradams.service.ParadaService;

import java.util.List;

@RestController
@RequestMapping("/parada")
public class ParadaController {
    @Autowired
    private ParadaService ParadaService;

    @GetMapping("")
    public List<ParadaDto> getAllParadas() {
        return ParadaService.getAll();
    }

    @GetMapping("/{id}")
    public ParadaDto getParadaById(@PathVariable Long id) {
        return ParadaService.getById(id);
    }

    @PostMapping("/add")
    public ParadaDto createParada(@RequestBody ParadaDto cuenta) {
        return ParadaService.create(cuenta);
    }

    @PutMapping("/update/{id}")
    public ParadaDto updateParada(@PathVariable Long id, @RequestBody ParadaDto parada) {
        return ParadaService.update(id, parada);
    }

    @DeleteMapping("/delete/{id}")
    public ParadaDto deleteParada(@PathVariable Long id) {
        return ParadaService.delete(id);
    }
}

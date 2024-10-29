package tpespecial.viajems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;
import tpespecial.viajems.service.ViajeService;

import java.util.List;

@RestController
@RequestMapping("/viaje")
public class ViajeController {
    @Autowired
    private ViajeService viajeService;

    @GetMapping
    public List<ViajeDto> getAllViajes(){
        return viajeService.getAllViajes();
    }

    @GetMapping("{/id}")
    public ViajeDto getVijeById(@PathVariable Long id){
        return viajeService.getViajeById(id);
    }

    @PostMapping("/add")
    public ViajeDto addViaje(@RequestBody ViajeDto viaje){
        return viajeService.addViaje(viaje);
    }

    @PutMapping("/update/{id}")
    public ViajeDto updateViaje(@RequestBody ViajeDto viaje, @PathVariable Long id){
        return viajeService.updateViaje(viaje,id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteViaje(@PathVariable Long id){
        viajeService.deleteViaje(id);
    }
}

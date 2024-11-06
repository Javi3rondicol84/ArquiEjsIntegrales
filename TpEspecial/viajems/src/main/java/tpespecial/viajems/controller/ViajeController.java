package tpespecial.viajems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.viajems.dto.ReporteTiempoDto;
import tpespecial.viajems.dto.ViajeDto;
import tpespecial.viajems.entity.Viaje;
import tpespecial.viajems.service.ViajeService;

import java.util.List;

@RestController
@RequestMapping("/viaje")
public class ViajeController {
    @Autowired
    private ViajeService viajeService;

    @GetMapping("")
    public List<ViajeDto> getAllViajes(){
        return viajeService.getAllViajes();
    }

    @GetMapping("/{id}")
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

    @PutMapping("/updateprecio/{id}")
    public ViajeDto updatePrecioViaje(@RequestBody double precio, @PathVariable Long id){
        return viajeService.updatePrecioViaje(precio,id);
    }

    @PutMapping("/updatetarifa/{id}")
    public ViajeDto updateTarifaViaje(@RequestBody double tarifaExtra,@PathVariable Long id){
        return viajeService.updateTarifaViaje(tarifaExtra,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteViaje(@PathVariable Long id){
        viajeService.deleteViaje(id);
    }

    @GetMapping("/viajesbymonopatin/{id}")
    public List<Viaje> getAllViajesByMonopatin(@PathVariable Long id){
        return viajeService.getAllViajesByMonopatin(id);
    }

    @GetMapping("/reportetiempoconpausa")
    public List<ReporteTiempoDto> getReporteTiempoConPausa(){
        return viajeService.getReporteTiempoConPausa();
    }

    @GetMapping("/reportetiemposinpausa")
    public List<ReporteTiempoDto> getReporteTiempoSinPausa(){
        return viajeService.getReporteTiempoSinPausa();
    }

}

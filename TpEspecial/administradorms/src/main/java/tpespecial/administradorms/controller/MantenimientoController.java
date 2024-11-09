package tpespecial.administradorms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.administradorms.dto.MantenimientoDto;
import tpespecial.administradorms.dto.ReporteKilometrosDto;
import tpespecial.administradorms.dto.ReporteTiempoDto;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Viaje;
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
    @PutMapping("/ponerenmantenimiento/{id}")
    Monopatin monopatinEnMantenimiento(@RequestBody boolean habilitado,@PathVariable Long id){
        return mantenimientoService.monopatinEnMantenimiento(habilitado,id);
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

    @GetMapping("/viajes")
    public List<Viaje> getAllViajes(){
        return mantenimientoService.getAllViajes();
    }

    @GetMapping("/monopatines")
    public List<Monopatin> getAllMonopatin(){
        return mantenimientoService.getAllMonopatines();
    }

    @GetMapping("/reportekilometros/{incluyepausa}")
    public List<ReporteKilometrosDto> getReporteKilometros(@PathVariable boolean incluyepausa){

        return mantenimientoService.getReporteKilometros(incluyepausa);
    }
    @GetMapping("/reportetiempoconpausa")
    public List<ReporteTiempoDto> getReporteTiempoConPausa(){
        return mantenimientoService.getReporteTiempoConPausa();
    }

    @GetMapping("/reportetiemposinpausa")
    public List<ReporteTiempoDto> getReporteTiempoSinPausa(){
        return mantenimientoService.getReporteTiempoSinPausa();
    }


}

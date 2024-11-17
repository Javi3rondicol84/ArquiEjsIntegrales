package tpespecial.administradorms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tpespecial.administradorms.dto.CantidadMonopatinesDto;
import tpespecial.administradorms.dto.ReporteKilometrosDto;
import tpespecial.administradorms.dto.ReporteTiempoDto;
import tpespecial.administradorms.model.Monopatin;

import java.util.List;

@FeignClient(name="monopatinms", url="http://localhost:8002/monopatin")
public interface MonopatinFeignClient {
    @PostMapping("/add")
    Monopatin createMonopatin(@RequestBody Monopatin monopatin);
    @DeleteMapping("/delete/{id}")
    Monopatin delete(@PathVariable String id);
    @PutMapping("/mantenimiento/{id}")
    Monopatin mantenimiento(@RequestBody boolean habilitado,@PathVariable String id);
    @GetMapping("")
    List<Monopatin> getMonopatines();
    @GetMapping("/reportekilometros/{incluyepausa}")
    List<ReporteKilometrosDto> getReporteKilometros(@PathVariable boolean incluyePausa);
    @GetMapping("/reportetiempoconpausa")
    List<ReporteTiempoDto> getReporteTiempoConPausa();
    @GetMapping("/reportetiemposinpausa")
    List<ReporteTiempoDto> getReporteTiempoSinPausa();
    @GetMapping("/xviajesenunciertoanio/cantviajes/{viajes}/fecha/{anio}")
    List<Monopatin> getMonopatinesMasXViajes(@PathVariable int viajes,@PathVariable int anio);
    @GetMapping("/mantenimientovsoperacion")
    CantidadMonopatinesDto monopatinesMantenimientoVsOperacion();
    @GetMapping("/monopatinescercanos/{ubicacion}")
    List<Monopatin> monopatinesCercanos(@PathVariable String ubicacion);
}

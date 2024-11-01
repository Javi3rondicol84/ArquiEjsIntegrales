package tpespecial.administradorms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tpespecial.administradorms.dto.ReporteKilometrosDto;
import tpespecial.administradorms.model.Monopatin;

import java.util.List;

@FeignClient(name="monopatinms", url="http://localhost:8002/monopatin")
public interface MonopatinFeignClient {
    @PostMapping("/add")
    Monopatin createMonopatin(@RequestBody Monopatin monopatin);
    @DeleteMapping("/delete/{id}")
    Monopatin delete(@PathVariable Long id);
    @PutMapping("/mantenimiento/{id}")
    Monopatin mantenimiento(@RequestBody boolean habilitado,@PathVariable Long id);
    @PutMapping("/agregarenparada/{id}")
    Monopatin agregarEnParada(@RequestBody String gps,@PathVariable Long id);

    @GetMapping("/reportekilometros")
    List<ReporteKilometrosDto> getReporteKilometros();
    @GetMapping("/reportetiempoconpausa")
    List<Monopatin> getReporteTiempoConPausa();
    @GetMapping("/reportetiemposinpausa")
    List<Monopatin> getReporteTiempoSinPausa();
}

package tpespecial.administradorms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Parada;

@FeignClient(name="paradams", url="http://localhost:8003/parada")
public interface ParadaFeignClient {
    @PostMapping("/add")
    Parada createParada(@RequestBody Parada parada);
    @DeleteMapping("/delete/{id}")
    Parada deleteParada(@PathVariable Long id);
    @GetMapping("/ubicarenparada/{gps}")
    int ubicarEnParada(@PathVariable String gps);
}

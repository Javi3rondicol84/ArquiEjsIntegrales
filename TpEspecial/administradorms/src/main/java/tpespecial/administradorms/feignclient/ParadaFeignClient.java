package tpespecial.administradorms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Parada;

@FeignClient(name="paradams", url="http://localhost:8003/parada")
public interface ParadaFeignClient {
    @PostMapping("/add")
    Parada create(@RequestBody Parada parada);
    @DeleteMapping("/delete/{id}")
    Parada delete(@PathVariable Long id);
}

package tpespecial.administradorms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tpespecial.administradorms.model.Monopatin;

@FeignClient(name="monopatinms", url="http://localhost:8002/monopatin")
public interface MonopatinFeignClient {
    @PostMapping("/add")
    Monopatin create(@RequestBody Monopatin monopatin);
    @DeleteMapping("/delete/{id}")
    Monopatin delete(@PathVariable Long id);
}

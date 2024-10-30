package tpespecial.administradorms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tpespecial.administradorms.model.Viaje;

import java.util.List;

@FeignClient(name="viajems", url="http://localhost:8004/viaje")
public interface ViajeFeignClient {
    @PutMapping("/updateprecio/{id}")
    Viaje updatePrecioViaje(@RequestBody double precio, @PathVariable int id);

    @PutMapping("/updatetarifa/{id}")
    Viaje updateTarifaViaje(@RequestBody double tarifaExtra, @PathVariable int id);
    @GetMapping("")
    List<Viaje> getAllViajes();
    @GetMapping("/viajesbymonopatin/{id}")
    List<Viaje> getAllViajesByMonopatin(@PathVariable Long id);
}


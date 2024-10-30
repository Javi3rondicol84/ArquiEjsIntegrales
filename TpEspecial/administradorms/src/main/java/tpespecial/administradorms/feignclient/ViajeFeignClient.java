package tpespecial.administradorms.feignclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tpespecial.administradorms.model.Viaje;

@FeignClient(name="viajems", url="http://localhost:8004/viaje")
public interface ViajeFeignClient {
    @PutMapping("/updateprecio/{id}")
    Viaje updatePrecioViaje(@RequestBody double precio, @PathVariable int id);

    @PutMapping("/updatetarifa/{id}")
    Viaje updateTarifaViaje(@RequestBody double tarifaExtra, @PathVariable int id);
}

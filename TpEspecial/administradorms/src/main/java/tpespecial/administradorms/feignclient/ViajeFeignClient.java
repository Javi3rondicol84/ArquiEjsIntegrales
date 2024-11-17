package tpespecial.administradorms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tpespecial.administradorms.dto.ReporteTiempoDto;
import tpespecial.administradorms.model.Viaje;

import java.util.List;

@FeignClient(name="viajems", url="http://localhost:8004/viaje")
public interface ViajeFeignClient {

    @PutMapping("/updateprecio/{id}")
    Viaje updatePrecioViaje(@RequestBody double precio, @PathVariable Long id);

    @PutMapping("/updatetarifa/{id}")
    Viaje updateTarifaViaje(@RequestBody double tarifaExtra, @PathVariable Long id);

    @GetMapping("")
    List<Viaje> getAllViajes();

    @GetMapping("/viajesbymonopatin/{idMonopatin}")
    List<Viaje> getAllViajesByMonopatin(@PathVariable String idMonopatin);

    @GetMapping("/reportetiempoconpausa")
    List<ReporteTiempoDto> getReporteTiempoConPausa();

    @GetMapping("/reportetiemposinpausa")
    List<ReporteTiempoDto> getReporteTiempoSinPausa();

    @GetMapping("/cumplerequisitosmonopatin/{id}/viajecantidad/{viajes}/fecha/{anio}")
    boolean cumpleRequisitosMonopatin(@PathVariable String id,@PathVariable int viajes,@PathVariable int anio);

    @GetMapping("/totalfacturado/inicio/{mes1}/fin/{mes2}/fecha/{anio}")
    Double totalFacturado(@PathVariable int mes1,@PathVariable int mes2, @PathVariable int anio);

    @GetMapping("/actualizarprecios/tarifaextra/{tarifa}/precioviaje/{precio}")
    void actualizarPrecios(@PathVariable double tarifa, @PathVariable double precio);
}



package tpespecial.administradorms.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tpespecial.administradorms.model.Cuenta;


@FeignClient(name="usuarioms", url="http://localhost:8005")
public interface UsuarioFeignClient {
    @PutMapping("/cuenta/anularcuenta/{id}")
    Cuenta anularCuenta(@RequestBody boolean habilitado, @PathVariable Long id);
}

package tpespecial.usuarioms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.usuarioms.dto.CuentaDto;
import tpespecial.usuarioms.service.CuentaService;

import java.util.List;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("")
    public List<CuentaDto> getAllCuentas() {
        return cuentaService.getAll();
    }

    @GetMapping("/{id}")
    public CuentaDto getCuentasById(@PathVariable Long id) {
        return cuentaService.getById(id);
    }

    @PostMapping("/add")
    public CuentaDto createCuenta(@RequestBody CuentaDto cuenta) {
        return cuentaService.create(cuenta);
    }

    @PutMapping("/update/{id}")
    public CuentaDto updateCuenta(@PathVariable Long id, @RequestBody CuentaDto cuenta) {
        return cuentaService.update(id, cuenta);
    }

    @PutMapping("/anularcuenta/{id}")
    public CuentaDto anularCuenta(@RequestBody boolean habilitado, @PathVariable Long id){
        return cuentaService.anularCuenta(habilitado, id);
    }

    @DeleteMapping("/delete/{id}")
    public CuentaDto deleteCuenta(@PathVariable Long id) {
        return cuentaService.delete(id);
    }

}

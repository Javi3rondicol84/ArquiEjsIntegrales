package tpespecial.administradorms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.administradorms.dto.AdministradorDto;
import tpespecial.administradorms.model.Cuenta;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Parada;
import tpespecial.administradorms.model.Viaje;
import tpespecial.administradorms.service.AdministradorService;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    private AdministradorService administradorService;

    @PostMapping("/add")
    AdministradorDto add(@RequestBody AdministradorDto administrador) {
        return administradorService.add(administrador);
    }

    @DeleteMapping("/delete/id")
    AdministradorDto delete(@PathVariable Long id) {
        return administradorService.deleteAdmin(id);
    }


    @GetMapping("")
    public List<AdministradorDto> getAllAdmins() {
        return administradorService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public AdministradorDto getAdminById(@PathVariable Long id) {
        return administradorService.getAdminById(id);
    }

    @PutMapping("/update/{id}")
    public AdministradorDto updateAdmin(@PathVariable Long id, @RequestBody AdministradorDto administradorDto) {
        return administradorService.updateAdmin(id, administradorDto);
    }


    @PostMapping("/createmonopatin")
    public Monopatin createMonopatin(@RequestBody Monopatin monopatin) {
        return administradorService.createMonopatin(monopatin);
    }

    @DeleteMapping("/deletemonopatin/{id}")
    public Monopatin deleteMonopatin(@PathVariable Long id){
        return administradorService.deleteMonopatin(id);
    }

    // administrador gestion de viajes

    @GetMapping("/getallviajes")
    public List<Viaje> getAllViajes() {
        return administradorService.getAllViajes();
    }

    @PutMapping("/updateprecio/{id}")
    public Viaje updatePrecio(@RequestBody double precio, @PathVariable Long id) {
        return administradorService.updatePrecio(precio, id);
    }

    @PutMapping("/updatetarifa/{id}")
    Viaje updateTarifaViaje(@RequestBody double tarifaExtra, @PathVariable Long id) {
        return administradorService.updateTarifa(tarifaExtra, id);
    }

    @PutMapping("/anularcuenta/{id}")
    public Cuenta anularCuenta(@RequestBody boolean habilitado, @PathVariable Long id){
        return administradorService.anularCuenta(habilitado,id);
    }

    @PostMapping("/createparada")
    Parada createParada(@RequestBody Parada parada){
        return administradorService.createParada(parada);
    }
    @DeleteMapping("/deleteparada/{id}")
    Parada deleteParada(@PathVariable Long id){
        return administradorService.deleteParada(id);
    }





}

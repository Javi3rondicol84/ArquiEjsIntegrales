package tpespecial.administradorms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tpespecial.administradorms.dto.AdministradorDto;
import tpespecial.administradorms.dto.CantidadMonopatinesDto;
import tpespecial.administradorms.model.Cuenta;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Parada;
import tpespecial.administradorms.model.Viaje;
import tpespecial.administradorms.service.AdministradorService;

import java.time.LocalDate;
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

    @DeleteMapping("/delete/{id}")
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
    public Monopatin deleteMonopatin(@PathVariable String id) {
        return administradorService.deleteMonopatin(id);
    }


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
    public Cuenta anularCuenta(@RequestBody boolean habilitado, @PathVariable Long id) {
        return administradorService.anularCuenta(habilitado, id);
    }

    @GetMapping("/ubicarenparada/{gps}")
    int ubicarEnParada(@PathVariable String gps) {
        return administradorService.ubicarEnParada(gps);
    }

    @PostMapping("/createparada")
    Parada createParada(@RequestBody Parada parada) {
        return administradorService.createParada(parada);
    }

    @DeleteMapping("/deleteparada/{id}")
    Parada deleteParada(@PathVariable Long id) {
        return administradorService.deleteParada(id);
    }

    @GetMapping("/monopatin/xviajesenunciertoanio/cantviajes/{viajes}/fecha/{anio}")
    public List<Monopatin> getMonopatinesMasXViajes(@PathVariable int viajes, @PathVariable int anio) {
        return administradorService.getMonopatinesMasXViajes(viajes, anio);
    }

    @GetMapping("/viajestotalfacturado/inicio/{mes1}/fin/{mes2}/fecha/{anio}")
    public Double viajesTotalFacturado(@PathVariable int mes1, @PathVariable int mes2, @PathVariable int anio) {
        Double total = administradorService.viajesTotalFacturado(mes1, mes2, anio);
        if(total == null){
            total = 0.0;
        }
        return total;
    }

    @GetMapping("/mantenimientovsoperacion")
    CantidadMonopatinesDto monopatinesMantenimientoVsOperacion(){
        return administradorService.monopatinesMantenimientoVsOperacion();
    }

    @Scheduled(cron = "0 0 0 * * *")
    @GetMapping("/actualizarprecios/tarifaextra/{tarifa}/precioviaje/{precio}/fecha/{fecha}")
    void actualizarPrecios(@PathVariable double tarifa, @PathVariable double precio, @PathVariable LocalDate fecha){
        if (LocalDate.now().isEqual(fecha)) {
            administradorService.actualizarPrecios(tarifa, precio);
        }
        System.out.println("llego");
    }

    @GetMapping("/usuario/monopatinescerca/{ubicacion}")
    List<Monopatin> monopatinesCercanos(@PathVariable String ubicacion){
        return administradorService.monopatinesCercanos(ubicacion);
    }

}

package jpa.gateway.controller;

import jpa.gateway.dto.RolDto;
import jpa.gateway.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;


    public List<RolDto> obtenerTodosLosRoles() {
        return rolService.obtenerTodosLosRoles();
    }

    @GetMapping("/{id}")
    public RolDto obtenerRolPorId(@PathVariable Long id) {
        return rolService.obtenerRolPorId(id);
    }

    @PostMapping("/agregar")
    public RolDto agregarRol(@RequestBody RolDto roleDto) {
        return rolService.agregarRol(roleDto);
    }

    @PutMapping("/actualizar/{id}")
    public RolDto actualizarRol(@PathVariable Long id, @RequestBody RolDto roleDto) {
        return rolService.actualizarRol(id, roleDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public RolDto eliminarRol(@PathVariable Long id) {
        return rolService.eliminarRol(id);
    }

    @GetMapping("/crearrolpordefecto")
    public void crearRolPorDefecto() {
        rolService.crearRolPorDefecto();
    }
}

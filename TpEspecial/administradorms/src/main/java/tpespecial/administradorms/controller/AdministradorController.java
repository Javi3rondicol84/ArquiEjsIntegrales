package tpespecial.administradorms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.administradorms.dto.AdministradorDto;
import tpespecial.administradorms.service.AdministradorService;

import java.util.List;

@RestController
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
}

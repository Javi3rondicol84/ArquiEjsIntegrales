package tpespecial.usuarioms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpespecial.usuarioms.dto.UsuarioDto;
import tpespecial.usuarioms.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController{

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDto> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @PostMapping("/add")
    public UsuarioDto addUsuario(@RequestBody UsuarioDto usuario){
        return usuarioService.addUsuario(usuario);
    }

    @GetMapping("/{id}")
    public UsuarioDto getUsuarioById(@PathVariable Long id){
        return usuarioService.getUsuarioById(id);
    }

    @PutMapping("/put/{id}")
    public UsuarioDto putUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuario){
        return usuarioService.putUsuario(id,usuario);
    }

    @DeleteMapping("/delete/{id}")
    public UsuarioDto deleteUsuario(@PathVariable Long id){
        return usuarioService.deleteUsuario(id);
    }
}
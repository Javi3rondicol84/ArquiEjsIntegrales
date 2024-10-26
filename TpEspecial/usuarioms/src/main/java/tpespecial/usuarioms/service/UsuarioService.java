package tpespecial.usuarioms.service;

import tpespecial.usuarioms.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> getAllUsuarios();
    UsuarioDto getUsuarioById(Long id);
    UsuarioDto addUsuario(UsuarioDto usuario);
    UsuarioDto putUsuario(Long id, UsuarioDto usuario);
    UsuarioDto deleteUsuario(Long id);

}

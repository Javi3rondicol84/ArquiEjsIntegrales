package tpespecial.usuarioms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.usuarioms.dto.UsuarioDto;
import tpespecial.usuarioms.entity.Usuario;
import tpespecial.usuarioms.repository.UsuarioRepository;
import tpespecial.usuarioms.service.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<UsuarioDto> getAllUsuarios(){
        return usuarioRepository.getAllUsuarios();
    }

    public UsuarioDto getUsuarioById(Long id){
       Usuario usuario = usuarioRepository.findById(id).orElse(null);
       if(usuario !=null){
           return new UsuarioDto(usuario.getNombre(),usuario.getApellido(),usuario.getNumeroTelefonico(),usuario.getEmail(),usuario.getGps());
       }
       return null;
    }

    public UsuarioDto addUsuario(UsuarioDto usuariodto){
        if(usuariodto!=null){
            Usuario us = new Usuario(usuariodto.getNombre(),usuariodto.getApellido(),usuariodto.getNumeroTelefonico(),usuariodto.getEmail(),usuariodto.getGps());
            usuarioRepository.save(us);
            return usuariodto;
        }
        else {
            return null;
        }
    }

    public UsuarioDto putUsuario(Long id, UsuarioDto usuariodto){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario != null){
            usuario.setNombre(usuariodto.getNombre());
            usuario.setApellido(usuariodto.getApellido());
            usuario.setNumeroTelefonico(usuariodto.getNumeroTelefonico());
            usuario.setEmail(usuariodto.getEmail());
            usuarioRepository.save(usuario);
        }
        else{
            return null;
        }
        return usuariodto;
    }
    public UsuarioDto deleteUsuario(Long id){

        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario != null){
            usuarioRepository.delete(usuario);
        }
        else {
            return null;
        }
        return new UsuarioDto(usuario.getNombre(),usuario.getApellido(),usuario.getNumeroTelefonico(),usuario.getEmail(),usuario.getGps());
    }
}
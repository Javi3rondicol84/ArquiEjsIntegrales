package tpespecial.administradorms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.administradorms.dto.AdministradorDto;
import tpespecial.administradorms.entity.Administrador;
import tpespecial.administradorms.feignclient.MonopatinFeignClient;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.repository.AdministradorRepository;
import tpespecial.administradorms.service.AdministradorService;

import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private MonopatinFeignClient monopatinFeignClient;

    @Override
    public AdministradorDto add(AdministradorDto admindto) {
        if(admindto==null){
            return null;
        }
        administradorRepository.save(new Administrador(admindto.getNombre()));
        return admindto;
    }

    @Override
    public AdministradorDto deleteAdmin(Long id) {
        Administrador admin = administradorRepository.findById(id).orElse(null);
        if(admin==null) {
            return null;
        }
        else{
            return new AdministradorDto(admin.getNombre());
        }

    }

    @Override
    public List<AdministradorDto> getAllAdmins() {
        return administradorRepository.getAll();
    }

    @Override
    public AdministradorDto getAdminById(Long id) {
        Administrador admin = administradorRepository.findById(id).orElse(null);
        if(admin==null) {
            return null;
        }
        return new AdministradorDto(admin.getNombre());
    }

    @Override
    public AdministradorDto updateAdmin(Long id, AdministradorDto administradorDto) {
        Administrador administrador = administradorRepository.findById(id).orElse(null);
        if(administrador==null) {
            return null;
        }
        administrador.setNombre(administradorDto.getNombre());
        administradorRepository.save(administrador);
        return new AdministradorDto(administrador.getNombre());
    }

    @Override
    public Monopatin createMonopatin(Monopatin monopatin) {
        return monopatinFeignClient.createMonopatin(monopatin);
    }
}

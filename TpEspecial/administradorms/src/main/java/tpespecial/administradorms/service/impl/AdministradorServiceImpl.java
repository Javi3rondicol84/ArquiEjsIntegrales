package tpespecial.administradorms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tpespecial.administradorms.dto.AdministradorDto;
import tpespecial.administradorms.entity.Administrador;
import tpespecial.administradorms.feignclient.MonopatinFeignClient;
import tpespecial.administradorms.feignclient.ParadaFeignClient;
import tpespecial.administradorms.feignclient.UsuarioFeignClient;
import tpespecial.administradorms.feignclient.ViajeFeignClient;
import tpespecial.administradorms.model.Cuenta;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Parada;
import tpespecial.administradorms.model.Viaje;
import tpespecial.administradorms.repository.AdministradorRepository;
import tpespecial.administradorms.service.AdministradorService;

import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private MonopatinFeignClient monopatinFeignClient;
    @Autowired
    private ViajeFeignClient viajeFeignClient;
    @Autowired
    private UsuarioFeignClient cuentaFeingClient;
    @Autowired
    private ParadaFeignClient paradaFeignClient;

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

    @Override
    public Cuenta anularCuenta(boolean habilitado, Long id) {
        return cuentaFeingClient.anularCuenta(habilitado,id);
    }

    @Override
    public Parada createParada(Parada parada) {
        return paradaFeignClient.createParada(parada);
    }

    @Override
    public Parada deleteParada(Long id) {
        return paradaFeignClient.deleteParada(id);
    }

    // administrador gestion de viajes
    @Override
    public Viaje updatePrecio(double precio, Long id) {
        return viajeFeignClient.updatePrecioViaje(precio, id);
    }

    @Override
    public Viaje updateTarifa(double tarifaExtra, Long id) {
        return viajeFeignClient.updateTarifaViaje(tarifaExtra, id);
    }

    @Override
    public List<Viaje> getAllViajesByMonopatin(Long idMonopatin) {
        return viajeFeignClient.getAllViajesByMonopatin(idMonopatin);
    }

    //este funciona
    @Override
    public List<Viaje> getAllViajes() {
        return viajeFeignClient.getAllViajes();
    }


}

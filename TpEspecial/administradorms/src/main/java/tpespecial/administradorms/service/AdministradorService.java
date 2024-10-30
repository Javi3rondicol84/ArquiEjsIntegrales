package tpespecial.administradorms.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tpespecial.administradorms.dto.AdministradorDto;
import tpespecial.administradorms.model.Monopatin;

import java.util.List;

public interface AdministradorService {

    AdministradorDto add(AdministradorDto admin);
    AdministradorDto deleteAdmin(Long id);

    List<AdministradorDto> getAllAdmins();
    AdministradorDto getAdminById(Long id);
    AdministradorDto updateAdmin(Long id, AdministradorDto administradorDto);
    Monopatin createMonopatin(Monopatin monopatin);
}

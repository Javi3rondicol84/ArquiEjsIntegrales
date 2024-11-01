package tpespecial.administradorms.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tpespecial.administradorms.dto.AdministradorDto;
import tpespecial.administradorms.dto.ReporteKilometrosDto;
import tpespecial.administradorms.model.Cuenta;
import tpespecial.administradorms.model.Monopatin;
import tpespecial.administradorms.model.Parada;
import tpespecial.administradorms.model.Viaje;

import java.util.List;

public interface AdministradorService {

    AdministradorDto add(AdministradorDto admin);
    AdministradorDto deleteAdmin(Long id);

    List<AdministradorDto> getAllAdmins();
    AdministradorDto getAdminById(Long id);
    AdministradorDto updateAdmin(Long id, AdministradorDto administradorDto);
    Monopatin createMonopatin(Monopatin monopatin);
    Cuenta anularCuenta(boolean habilitado, Long id);
    Parada createParada(Parada parada);
    Parada deleteParada(Long id);
    // administrador gestion de viajes
    Viaje updatePrecio(double precio, Long id);
    Viaje updateTarifa(double tarifaExtra, Long id);
    List<Viaje> getAllViajes();


}

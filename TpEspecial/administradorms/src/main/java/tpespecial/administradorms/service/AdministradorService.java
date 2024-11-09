package tpespecial.administradorms.service;

import tpespecial.administradorms.dto.AdministradorDto;
import tpespecial.administradorms.dto.CantidadMonopatinesDto;
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
    Monopatin deleteMonopatin(Long id);
    Cuenta anularCuenta(boolean habilitado, Long id);
    Parada createParada(Parada parada);
    Parada deleteParada(Long id);
    int ubicarEnParada(String gps);
    // administrador gestion de viajes
    Viaje updatePrecio(double precio, Long id);
    Viaje updateTarifa(double tarifaExtra, Long id);
    List<Viaje> getAllViajes();
    List<Monopatin> getMonopatinesMasXViajes(int viajes, int anio);
    double viajesTotalFacturado(int mes1, int mes2,int anio);
    CantidadMonopatinesDto monopatinesMantenimientoVsOperacion();
    void actualizarPrecios(double tarifa, double precio);
    List<Monopatin> monopatinesCercanos(String ubicacion);
}

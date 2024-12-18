package tpespecial.monopatinms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpespecial.monopatinms.dto.CantidadMonopatinesDto;
import tpespecial.monopatinms.dto.MonopatinDto;
import tpespecial.monopatinms.entity.Monopatin;
import tpespecial.monopatinms.repository.MonopatinRepository;
import tpespecial.monopatinms.service.MonopatinService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonopatinServiceImpl implements MonopatinService {
    @Autowired
    private MonopatinRepository monopatinRepository;

    @Override
    public List<MonopatinDto> getAll() {
        return monopatinRepository.getAll();
    }

    @Override
    public MonopatinDto getById(Long id) {
        Monopatin monopatin = monopatinRepository.findById(id).orElse(null);
        if(monopatin == null) {
            return null;
        }
        return new MonopatinDto(monopatin.getIdMonopatin(),monopatin.isEncendido(), monopatin.getGps(), monopatin.getKilometrosRecorridos(), monopatin.getTiempoDeUso(), monopatin.isHabilitado());
    }

    @Override
    public MonopatinDto create(MonopatinDto monopatinDto) {
        if(monopatinDto == null) {
            return null;
        }
        monopatinRepository.save(new Monopatin(monopatinDto.isEncendido(), monopatinDto.getGps(), monopatinDto.getKilometrosRecorridos(), monopatinDto.getTiempoDeUso(), monopatinDto.isHabilitado()));
        return monopatinDto;
    }

    @Override
    public MonopatinDto update(Long id, MonopatinDto monopatinDto) {
        Monopatin monopatin = monopatinRepository.findById(id).orElse(null);

        if(monopatin == null) {
            return null;
        }

        monopatin.setGps(monopatinDto.getGps());
        monopatin.setEncendido(monopatinDto.isEncendido());
        monopatin.setHabilitado(monopatinDto.isHabilitado());
        monopatin.setTiempoDeUso(monopatinDto.getTiempoDeUso());
        monopatin.setKilometrosRecorridos(monopatinDto.getKilometrosRecorridos());

        monopatinRepository.save(monopatin);

        return monopatinDto;
    }

    @Override
    public MonopatinDto delete(Long id) {
        Monopatin monopatin = monopatinRepository.findById(id).orElse(null);

        if(monopatin == null) {
            return null;
        }

        monopatinRepository.delete(monopatin);

        return new MonopatinDto(monopatin.getIdMonopatin(),monopatin.isEncendido(), monopatin.getGps(), monopatin.getKilometrosRecorridos(), monopatin.getTiempoDeUso(), monopatin.isHabilitado());
    }

    @Override
    public MonopatinDto mantenimiento(boolean habilitado, Long id) {
        Monopatin monopatin = monopatinRepository.findById(id).orElse(null);
        if(monopatin == null){
            return null;
        }
        monopatin.setHabilitado(habilitado);
        monopatinRepository.save(monopatin);
        return new MonopatinDto(monopatin.getIdMonopatin(),monopatin.isEncendido(), monopatin.getGps(), monopatin.getKilometrosRecorridos(), monopatin.getTiempoDeUso(), monopatin.isHabilitado());
    }

    @Override
    public CantidadMonopatinesDto monopatinesMantenimientoVsOperacion() {
        return monopatinRepository.monopatinesMantenimientoVsOperacion();
    }

    @Override
    public List<MonopatinDto> monopatinesCercanos(String ubicacion) {
        String[] ubicacionArray = ubicacion.split(",");
        double latUsuario = Double.parseDouble(ubicacionArray[0]);
        double lonUsuario = Double.parseDouble(ubicacionArray[1]);

        List<Monopatin> monopatines = monopatinRepository.findAll();
        double radioProximidad = 0.001;
        List<MonopatinDto> resultado = new ArrayList<>();

        for (Monopatin monopatin : monopatines) {
            String[] gpsArray = monopatin.getGps().split(",");
            double latMonopatin = Double.parseDouble(gpsArray[0]);
            double lonMonopatin = Double.parseDouble(gpsArray[1]);

            double distancia = calcularDistancia(latUsuario, lonUsuario, latMonopatin, lonMonopatin);

            if (distancia <= radioProximidad) {
                resultado.add(new MonopatinDto(monopatin.getIdMonopatin(),monopatin.isEncendido(), monopatin.getGps(), monopatin.getKilometrosRecorridos(), monopatin.getTiempoDeUso(), monopatin.isHabilitado()));
            }
        }

        return resultado;
    }


    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2));
    }


}

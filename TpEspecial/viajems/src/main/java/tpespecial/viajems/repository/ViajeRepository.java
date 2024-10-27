package tpespecial.viajems.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tpespecial.viajems.entity.Viaje;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
}

package cl.pfequipo1.proyecto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SensorRepository  extends JpaRepository<Sensor, Integer> {
    List<Sensor> findByLocation(Location location);
    Optional<Sensor> findBySensorApiKey(String apiKey);
}

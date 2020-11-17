package pl.krysinski.weatherdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krysinski.weatherdb.model.WeatherDto;

@Repository
public interface WeatherRepo extends JpaRepository<WeatherDto, Long> {
}

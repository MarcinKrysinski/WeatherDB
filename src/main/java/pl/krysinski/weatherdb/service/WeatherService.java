package pl.krysinski.weatherdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krysinski.weatherdb.model.WeatherDto;
import pl.krysinski.weatherdb.repository.WeatherRepo;

@Service
public class WeatherService {

    private WeatherRepo weatherRepo;

    @Autowired
    public WeatherService(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    public void saveWeatherInDB(WeatherDto weather){
        weatherRepo.save(weather);
    }

    public void printAllRecordsInDB(){
        weatherRepo.findAll().forEach(System.out::println);
    }
}

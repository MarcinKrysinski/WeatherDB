package pl.krysinski.weatherdb.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.krysinski.weatherdb.client.WeatherClient;
import pl.krysinski.weatherdb.service.WeatherService;


@Component
@EnableScheduling
public class Application {

    private WeatherService weatherService;
    private WeatherClient weatherClient;

    @Autowired
    public Application(WeatherService weatherService, WeatherClient weatherClient) {
        this.weatherService = weatherService;
        this.weatherClient = weatherClient;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void addWeatherToDB(){
        weatherService.saveWeatherInDB(weatherClient.getWeatherFromApi());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void printAllDatabaseRecords(){
        weatherService.printAllRecordsInDB();
    }
}

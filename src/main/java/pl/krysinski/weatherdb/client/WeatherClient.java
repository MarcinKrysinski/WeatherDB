package pl.krysinski.weatherdb.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.krysinski.weatherdb.model.WeatherDto;
import pl.krysinski.weatherdb.model.openweatherApi.Weather;

@Component
public class WeatherClient {

    @Value("${weatherClient.apiKey}")
    private String apiKey;
    private final String city = "Gdansk";
    private RestTemplate restTemplate = new RestTemplate();

       public WeatherDto getWeatherFromApi(){
        Weather weather = restTemplate.getForObject(String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s", city, apiKey), Weather.class);
        return new WeatherDto(weather.getName(), weather.getMain().getTemp(), weather.getWind().getSpeed(), weather.getMain().getPressure(), weather.getMain().getHumidity(), weather.getClouds().getAll());
    }
}

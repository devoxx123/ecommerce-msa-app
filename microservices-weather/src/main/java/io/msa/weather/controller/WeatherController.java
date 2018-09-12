package io.msa.weather.controller;

import io.msa.weather.exception.OpenWeatherMapServiceException;
import io.msa.weather.models.WeatherInfo;
import io.msa.weather.service.WeatherService;
import net.aksingh.owmjapis.api.APIException;
import java.io.IOException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService IWeatherService;

    @Autowired
    public WeatherController(WeatherService IWeatherService) {
        this.IWeatherService = IWeatherService;
    }

    @RequestMapping(value = "/current/{cityCode}")
    public WeatherInfo getCurrentWeatherForCity(@PathVariable(value = "cityCode") String cityCode) throws OpenWeatherMapServiceException,JSONException, IOException, NumberFormatException, APIException {
        return IWeatherService.getCurrentWeatherForCity(cityCode).orElseThrow(() -> new OpenWeatherMapServiceException("Weather data unavailable"));
    }
    @RequestMapping(value ="/current/{cityName}", method = RequestMethod.GET)
    public WeatherInfo getCurrentWeatherForCityName(@PathVariable(value="cityName") String cityName) throws OpenWeatherMapServiceException, JSONException, IOException, APIException{
		return IWeatherService.getCurrentWeatherForCityName(cityName).orElseThrow(()-> new OpenWeatherMapServiceException("Weather data unavailable"));
    	
    }
}

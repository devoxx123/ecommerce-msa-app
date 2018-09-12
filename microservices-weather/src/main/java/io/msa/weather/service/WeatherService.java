package io.msa.weather.service;

import io.msa.weather.config.CurrentWeather2WeatherReportMapper;
import io.msa.weather.exception.InvalidCityCodeException;
import io.msa.weather.exception.InvalidCityNameException;
import io.msa.weather.models.WeatherInfo;
import io.msa.weather.utils.ValidationUtils;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Optional;

@Service
public class WeatherService {

	private OWM owm;

	private CurrentWeather2WeatherReportMapper mapper;

	private ValidationUtils validationUtils;

	public Optional<WeatherInfo> getCurrentWeatherForCity(String cityCode)throws JSONException, IOException, NumberFormatException, APIException {
		if (!validationUtils.isValidCityCode(cityCode)) {
			throw new InvalidCityCodeException();
		}
		CurrentWeather cwm = owm.currentWeatherByCityId(Integer.valueOf(cityCode));
		return (validationUtils.isValidWeatherResponse(cwm)) ? mapper.map(cwm) : Optional.empty();
	}

	public Optional<WeatherInfo> getCurrentWeatherForCityName(String cityName) throws JSONException, IOException, APIException {
		if (!validationUtils.isValidCityName(cityName)) {
			throw new InvalidCityNameException();
		}
		CurrentWeather cwm = owm.currentWeatherByCityName(String.valueOf(cityName));
		return (validationUtils.isValidWeatherResponses(cwm)) ? mapper.map(cwm) : Optional.empty();
	}

}
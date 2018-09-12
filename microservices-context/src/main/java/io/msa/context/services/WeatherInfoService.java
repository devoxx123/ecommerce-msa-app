package io.msa.context.services;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import io.msa.context.config.CurrentWeather2WeatherReportMapper;
import io.msa.context.exception.InvalidCityCodeException;
import io.msa.context.exception.InvalidCityNameException;
import io.msa.context.models.WeatherInfo;
import io.msa.context.utils.ValidationUtils;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

@Service
public class WeatherInfoService {
	private OWM owm;

	private CurrentWeather2WeatherReportMapper mapper;

	private ValidationUtils validationUtils;

	public WeatherInfoService(String openWeatherMapApiKey, CurrentWeather2WeatherReportMapper mapper,
			ValidationUtils validationUtils) {
		this.owm = new OWM(openWeatherMapApiKey);
		this.mapper = mapper;
		this.validationUtils = validationUtils;
	}

	public Optional<WeatherInfo> getCurrentWeatherForCity(String cityCode)
			throws JSONException, IOException, NumberFormatException, APIException {
		if (!validationUtils.isValidCityCode(cityCode)) {
			throw new InvalidCityCodeException();
		}
		CurrentWeather cwm = owm.currentWeatherByCityId(Integer.valueOf(cityCode));
		return (validationUtils.isValidWeatherResponse(cwm)) ? mapper.map(cwm) : Optional.empty();
	}

	public Optional<WeatherInfo> getCurrentWeatherForCityName(String cityName)
			throws JSONException, IOException, APIException {
		if (!validationUtils.isValidCityName(cityName)) {
			throw new InvalidCityNameException();
		}
		CurrentWeather cwm = owm.currentWeatherByCityName(String.valueOf(cityName));
		return (validationUtils.isValidWeatherResponses(cwm)) ? mapper.map(cwm) : Optional.empty();
	}

}

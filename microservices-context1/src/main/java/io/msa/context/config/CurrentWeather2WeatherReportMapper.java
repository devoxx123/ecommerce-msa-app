package io.msa.context.config;

import org.springframework.stereotype.Component;

import io.msa.context.models.WeatherInfo;
import net.aksingh.owmjapis.model.CurrentWeather;

import java.util.Optional;

@Component
public class CurrentWeather2WeatherReportMapper {

	public Optional<WeatherInfo> map(CurrentWeather cwd) {
		WeatherInfo weatherReport = new WeatherInfo();
		weatherReport.setCityId(cwd.getCityId());
		weatherReport.setCityName(cwd.getCityName());
		weatherReport.setWeatherDesc(cwd.getWeatherList().get(0).getDescription());
		weatherReport.setWeatherIconName(cwd.getWeatherList().get(0).getMainInfo());
		weatherReport.setWeatherName(cwd.getWeatherList().get(0).getMoreInfo());
		weatherReport.setWeatherCode(cwd.getWeatherList().get(0).getIconCode());
		weatherReport.setWeatherIconLink(cwd.getWeatherList().get(0).getIconLink());		
		weatherReport.setTempInFahrenheit(Double.valueOf(cwd.getMainData().getTemp()));
		weatherReport.setDateToday(cwd.getDateTime());
		weatherReport.setTimeAtSunrise(cwd.getSystemData().getSunriseDateTime());
		weatherReport.setTimeAtSunset(cwd.getSystemData().getSunsetDateTime());
		weatherReport.setCountryCode(cwd.getSystemData().getCountryCode());
		weatherReport.setWeatherMessage(cwd.getSystemData().getMessage());
		weatherReport.setType(cwd.getSystemData().getType());
		weatherReport.setSysId(cwd.getSystemData().getId());
		weatherReport.setCloudsAll(cwd.getCloudData().getCloud());
		weatherReport.setPercentageOfClouds(cwd.getCloudData().hasCloud());
		weatherReport.setWindDegree(cwd.getWindData().getDegree());
		weatherReport.setWindSpeed(cwd.getWindData().getSpeed());
		weatherReport.setWindGuest(cwd.getWindData().getGust());
		weatherReport.setLatitude(cwd.getCoordData().getLatitude());
		weatherReport.setLongitude(cwd.getCoordData().getLongitude());
		weatherReport.setHumidity(cwd.getMainData().getHumidity());
		weatherReport.setMaxTemp(cwd.getMainData().getTempMax());
		weatherReport.setMinTemp(cwd.getMainData().getTempMin());
		weatherReport.setPressure(cwd.getMainData().getPressure());
		weatherReport.setBase(cwd.getBaseStation());		
		return Optional.of(weatherReport);
	}

}

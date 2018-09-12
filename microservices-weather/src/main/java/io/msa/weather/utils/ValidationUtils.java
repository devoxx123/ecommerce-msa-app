package io.msa.weather.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.aksingh.owmjapis.model.CurrentWeather;

@Component
public class ValidationUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationUtils.class);

    public boolean isValidCityCode(String cityCode) {
        try {
            Long.valueOf(cityCode);
        } catch (NumberFormatException ex) {
            LOGGER.info("Invalid city code provided");
            return false;
        }
        LOGGER.info("Valid city code provided");
        return true;
    }

    public boolean isValidWeatherResponse(CurrentWeather cwd) {
        if (!cwd.equals(cwd) || !cwd.hasCityId()
                || !cwd.hasDateTime() || !cwd.hasWeatherList()
                || !cwd.hassystemData() || !cwd.hasMainData()) {
            LOGGER.info("Invalid weather response");
            if (cwd.hasRespCode()) {
                LOGGER.info("Response code:" + cwd.getRespCode());
            }
            return false;
        }
        LOGGER.info("Valid weather response received");
        return true;
    }
    
    public boolean isValidCityName(String cityName) {
        try {
            String.valueOf(cityName);
        } catch (StringIndexOutOfBoundsException ex) {
            LOGGER.info("Invalid city name provided");
            return false;
        }
        LOGGER.info("Valid city name provided");
        return true;
    }

    public boolean isValidWeatherResponses(CurrentWeather cwd) {
        if (!cwd.equals(cwd) || !cwd.hasCityName()
                || !cwd.hasDateTime() || !cwd.hasWeatherList()
                || !cwd.hassystemData() || !cwd.hasMainData()) {
            LOGGER.info("Invalid weather response");
            if (cwd.hasRespCode()) {
                LOGGER.info("Response code:" + cwd.getRespCode());
            }
            return false;
        }
        LOGGER.info("Valid weather response received");
        return true;
    }
    
}

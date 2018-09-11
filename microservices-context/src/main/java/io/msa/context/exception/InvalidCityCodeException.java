package io.msa.context.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCityCodeException extends RuntimeException {
    public InvalidCityCodeException() {
        super("Invalid city code.");
    }
}


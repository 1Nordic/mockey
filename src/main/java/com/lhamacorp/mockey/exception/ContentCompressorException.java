package com.lhamacorp.mockey.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class ContentCompressorException extends RuntimeException {

    public ContentCompressorException(String message) {
        super(message);
    }
}
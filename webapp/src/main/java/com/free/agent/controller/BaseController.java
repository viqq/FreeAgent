package com.free.agent.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by antonPC on 23.06.15.
 */
@ControllerAdvice
public class BaseController {
    private static final Logger LOGGER = Logger.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    public String getFilms() {
        LOGGER.error("Exception!!! Catch in BaseController");
        return "login-form";
    }
}

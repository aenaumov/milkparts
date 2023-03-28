package ru.milkparts.web.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNotFoundException(final NotFoundException e) {
        log.info("404 message = {}, StackTrace = {}", e.getMessage(), e.getStackTrace());
        return new ModelAndView("404");
}


    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleException(final Throwable e) {
        log.info("500 message = {}, StackTrace = {}", e.getMessage(), e.getStackTrace());
        return new ModelAndView("500");
    }

}

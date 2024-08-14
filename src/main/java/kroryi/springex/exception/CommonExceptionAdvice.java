package kroryi.springex.exception;


import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.FileNotFoundException;
import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {


    //@ResponseBody =>
    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptNubmer(NumberFormatException numberFormatException) {
        log.error("---------------------");
        log.error(numberFormatException.getMessage());
        return "숫자 포맷에 예외가 발생";
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception e) {
        log.error("---------------------");
        log.error(e.getMessage());
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>" + e.getMessage() + "</li>");
        Arrays.stream(e.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>" + stackTraceElement + "</li>");
        });
        buffer.append("</ul>");

        return buffer.toString();
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)//404에러
    public String notFound(){

        return "custom404";
    }
}

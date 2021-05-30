package com.vektorel.exceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // Eğer belli kısımlarda kendinize özgü hata fırlatmak isterseniz bunu kullanmalısınız.
    @ExceptionHandler(ExampleManagerException.class)
    @Order(HIGHEST_PRECEDENCE)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleMusteriManagerException(ExampleManagerException exception){
        ErrorType errorType = exception.getErrorType();
        HttpStatus errorStatus = errorType.getHttpStatus();
        return new ResponseEntity<>(createError(errorType,exception),errorStatus);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> handleAllExceptions(Exception exception){
        ErrorType errorType = ErrorType.GLOBAL_EXCEPTOIN_ERROR;
        return new ResponseEntity<>(createError(errorType,exception),errorType.getHttpStatus());
    }


    @ExceptionHandler(InvalidFormatException.class)
    public final ResponseEntity<ErrorMessage> handleInvalidFormatException(
            InvalidFormatException exception
    ){
        ErrorType errorType = ErrorType.BAD_REQUEST_ERROR;
        return new ResponseEntity<>(createError(errorType,exception),errorType.getHttpStatus());
    }

    @ExceptionHandler(JDBCConnectionException.class)
    public final ResponseEntity<ErrorMessage> handleJDBCErrorException(
          HttpMessageNotReadableException exception
    ){ // Hata yakalamak.
        ErrorType errorType = ErrorType.JDBC_REQUEST_ERROR;
        return new ResponseEntity<>(createError(errorType,exception),errorType.getHttpStatus());
    }


    private ErrorMessage createError(ErrorType errorType, Exception exception){
        log.error("Bir Hata Oluştu....: {}",exception.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }
}

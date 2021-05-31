package com.project.bootcamp.exceptions;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class exceptionhandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(exceptions.class)
    protected ResponseEntity<exceptionsresponse> handleSecurity(exceptions e){
return ResponseEntity.status((HttpStatus.UNPROCESSABLE_ENTITY)).body(new exceptionsresponse(e.getMessage()));
    }

    @ExceptionHandler(notfoundE.class)
    protected ResponseEntity<exceptionsresponse> handleSecurity(notfoundE e){
        return ResponseEntity.status((HttpStatus.NOT_FOUND)).body(new exceptionsresponse(e.getMessage()));
}

}

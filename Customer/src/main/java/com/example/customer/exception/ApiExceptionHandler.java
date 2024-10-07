package com.example.customer.exception;

import com.example.customer.viewmodel.ErrorVm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String MESSAGE = "Error : URI: {}, ErrorCode: {},Message: {}";

   @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ErrorVm> handleAccessDeniedException(AccessDeniedException ex, WebRequest request) {
       HttpStatus status = HttpStatus.FORBIDDEN;
       String msg = ex.getMessage();

       return buildErrorResponse(status,msg,ex,request,403,"Access denied");
   }
    private ResponseEntity<ErrorVm> buildErrorResponse(HttpStatus status, String message,
                                                       Exception ex, WebRequest request, int statusCode, String title) {
        ErrorVm errorVm =
                new ErrorVm(status.toString(), title.isEmpty() ? status.getReasonPhrase() : title, message);

        if (request != null) {
            log.error(message, this.getServletPath(request), statusCode, message);
        }
        log.error(message, ex);
        return ResponseEntity.status(status).body(errorVm);
    }

    private String getServletPath(WebRequest webRequest) {
        ServletWebRequest servletRequest = (ServletWebRequest) webRequest;
        return servletRequest.getRequest().getServletPath();
    }

}

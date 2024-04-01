package org.zara.ecommercepriceserviceapi.config;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.zara.ecommercepriceserviceapi.application.exception.AccessDeniedException;
import org.zara.ecommercepriceserviceapi.application.exception.BadRequestException;
import org.zara.ecommercepriceserviceapi.application.exception.ResourceNotFoundException;
import org.zara.ecommercepriceserviceapi.application.exception.model.ErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    ErrorDetails errorDetails = ErrorDetails.builder()
            .timestamp(new Date())
            .message(ex.getMessage())
            .details(request.getDescription(false))
            .build();
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<ErrorDetails> badRequestException(BadRequestException ex, WebRequest request) {
    ErrorDetails errorDetails = ErrorDetails.builder()
            .timestamp(new Date())
            .message(ex.getMessage())
            .details(request.getDescription(false))
            .build();
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<ErrorDetails> accessDeniedException(AccessDeniedException ex, WebRequest request) {
    ErrorDetails errorDetails = ErrorDetails.builder()
            .timestamp(new Date())
            .message(ex.getMessage())
            .details(request.getDescription(false))
            .build();
    return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception ex, WebRequest request) {
    ErrorDetails errorDetails = ErrorDetails.builder()
            .timestamp(new Date())
            .message("An error occurred processing your request.")
            .details(ex.getMessage())
            .build();
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

package org.zara.ecommercepriceserviceapi.application.exception;


public class BadRequestException extends RuntimeException {
    public BadRequestException (String message) {
        super(message);
    }
}


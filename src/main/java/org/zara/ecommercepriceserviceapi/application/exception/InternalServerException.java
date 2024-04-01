package org.zara.ecommercepriceserviceapi.application.exception;


public class InternalServerException extends RuntimeException {
    public InternalServerException(String message) {
        super(message);
    }
}


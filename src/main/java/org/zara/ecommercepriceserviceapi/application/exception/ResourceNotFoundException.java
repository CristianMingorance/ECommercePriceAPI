package org.zara.ecommercepriceserviceapi.application.exception;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException (String message) {
        super(message);
    }
}


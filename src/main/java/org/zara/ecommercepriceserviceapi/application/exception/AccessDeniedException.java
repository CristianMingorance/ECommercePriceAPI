package org.zara.ecommercepriceserviceapi.application.exception;

public class AccessDeniedException   extends RuntimeException {
    public AccessDeniedException  (String message) {
        super(message);
    }
}


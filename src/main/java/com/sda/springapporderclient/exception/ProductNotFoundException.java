package com.sda.springapporderclient.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Product not found");
    }

    public ProductNotFoundException(Long id) {
        super("Not found productId: " + id);
    }
}

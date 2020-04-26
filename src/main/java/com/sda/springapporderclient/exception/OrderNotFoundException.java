package com.sda.springapporderclient.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
        super("Order not found");
    }

    public OrderNotFoundException(Long id) {
        super("Not found orderId: " + id);
    }
}

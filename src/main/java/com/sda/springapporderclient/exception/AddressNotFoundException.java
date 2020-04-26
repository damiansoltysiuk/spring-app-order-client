package com.sda.springapporderclient.exception;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException() {
        super("Address not found");
    }

    public AddressNotFoundException(Long id) {
        super("Not found addressId: " + id);
    }
}

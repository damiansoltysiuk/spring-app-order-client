package com.sda.springapporderclient.service;

import com.sda.springapporderclient.exception.AddressNotFoundException;
import com.sda.springapporderclient.exception.UserNotFoundException;
import com.sda.springapporderclient.model.Address;
import com.sda.springapporderclient.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressService {
    AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address getOneById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address address) {
        Address toUpdate = getOneById(id);
        toUpdate.setCountry(address.getCountry());
        toUpdate.setCity(address.getCity());
        toUpdate.setStreet(address.getStreet());
        toUpdate.setFlatNo(address.getFlatNo());
        toUpdate.setUser(address.getUser());
        return saveAddress(toUpdate);
    }

    public void deleteAddress(Long id) {
        Address toDelete = getOneById(id);
        addressRepository.delete(toDelete);
    }

    public List<Address> getUserAddress(String username) {
        return addressRepository.findUserAddress(username).orElseThrow(() -> new UserNotFoundException(username));
    }
}

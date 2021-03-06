package com.lmmartins.cartorio.services;

import com.lmmartins.cartorio.dto.Response;
import com.lmmartins.cartorio.models.Address;
import com.lmmartins.cartorio.repositories.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private IAddressRepository repository;

    public Response deleteAddressById(Long addressId) {
        Optional<Address> address = repository.findById(addressId);
        if (address.isEmpty()) {
            return new Response(false,404,"Not found the office.");
        }
        else {
            try {
                repository.deleteById(addressId);
                return new Response(true,200, null);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new Response(false,500, "Internal error.");
            }
        }
    }

    public Response updateAddressById(Long addressId, Address address){
        Address updatedAddress = new Address(
                addressId,
                address.getStreet(),
                address.getCity(),
                address.getState()
        );

        try {
            repository.save(updatedAddress);
            return new Response(true, 200, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Response(false, 500, null);
        }
    }

    public Response createAddress(Address address){
        try {
            return new Response(true, 200,null, repository.save(address).getId());
        } catch (Exception e) {
            return new Response(false, 500, null);
        }
    }

    public List<Address> getAddresses(){
        try {
            return repository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public Address getAddressById(Long addressId){
        try {
            return repository.findById(addressId).get();
        } catch (Exception e) {
            return null;
        }
    }
}

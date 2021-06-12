package com.lmmartins.cartorio.controllers;

import com.lmmartins.cartorio.models.Address;
import com.lmmartins.cartorio.repositories.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v1/address")
public class AddressControllers{
    @Autowired
    private IAddressRepository repository;

    @GetMapping
    public ResponseEntity getAddresses() {
        List<Address> addresses = repository.findAll();
        return addresses.isEmpty() ? noContent().build() : ok(addresses);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity deleteAddressById(@PathVariable("addressId") Long addressId) {
        return ok().build();
    }

    @PostMapping
    public ResponseEntity createAddress(@RequestBody Address address) {
        Address savedAddress = repository.save(address);
        return created(null).body("Address created with ID: "+ savedAddress.getId());
    }

    @PutMapping("/{addressId}")
    public ResponseEntity updateAddressById(@PathVariable("addressId") Long addressId) {
        return ok().build();
    }
}

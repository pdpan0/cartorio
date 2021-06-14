package com.lmmartins.cartorio.apis;

import com.lmmartins.cartorio.dto.Response;
import com.lmmartins.cartorio.models.Address;
import com.lmmartins.cartorio.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v1/addresses")
public class AddressAPI {
    @Autowired
    private AddressService service;

    @DeleteMapping("/{addressId}")
    public ResponseEntity deleteAddressById(@PathVariable("addressId") Long addressId) {
        Response response = service.deleteAddressById(addressId);
        return response.getSuccess() ?
                ok().build() :
                status(response.getStatusCode()).body(response.getErrorMessage());
    }

    @GetMapping
    public ResponseEntity getAddresses() {
        List<Address> addresses = service.getAddresses();
        return addresses.isEmpty() ? noContent().build() : ok(addresses);
    }

    @PostMapping
    public ResponseEntity createAddress(@RequestBody Address address) {
        Response response = service.createAddress(address);
        return response.getSuccess() ?
                created(null).body("Address created with ID: "+ response.getObjectId()) :
                status(response.getStatusCode()).body(response.getErrorMessage());
    }

    @PutMapping("/{addressId}")
    public ResponseEntity updateAddressById(
            @PathVariable("addressId") Long addressId,
            @RequestBody Address address
    ) {
        Response response = service.updateAddressById(addressId, address);
        return response.getSuccess() ?
                ok().build() :
                status(response.getStatusCode()).body(response.getErrorMessage());
    }
}

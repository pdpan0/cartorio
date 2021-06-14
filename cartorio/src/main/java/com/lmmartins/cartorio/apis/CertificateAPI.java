package com.lmmartins.cartorio.apis;

import com.lmmartins.cartorio.dto.Response;
import com.lmmartins.cartorio.interfaces.CertificateClient;
import com.lmmartins.cartorio.repositories.ICertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v1/certificates")
public class CertificateAPI {
    @Autowired
    CertificateClient client;

    @GetMapping
    public ResponseEntity getCertificates() {
        return ok(client.getCertificates());
    }

}

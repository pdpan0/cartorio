package com.lmmartins.cartorio.apis;

import com.lmmartins.cartorio.repositories.ICertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificateAPI {
    @Autowired
    private ICertificateRepository repository;
}

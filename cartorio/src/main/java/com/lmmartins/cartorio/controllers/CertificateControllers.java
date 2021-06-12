package com.lmmartins.cartorio.controllers;

import com.lmmartins.cartorio.repositories.ICertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertificateControllers {
    @Autowired
    private ICertificateRepository repository;
}

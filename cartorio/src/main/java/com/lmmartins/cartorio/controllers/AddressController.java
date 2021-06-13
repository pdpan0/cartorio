package com.lmmartins.cartorio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {

    @GetMapping("/addresses")
    String getAddress(Model model) {
        return "address";
    }
}

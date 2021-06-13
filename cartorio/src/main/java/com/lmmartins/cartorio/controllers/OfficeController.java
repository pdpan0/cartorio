package com.lmmartins.cartorio.controllers;

import com.lmmartins.cartorio.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class OfficeController {

    @Autowired
    private OfficeService service;

    @GetMapping("/offices")
    String getOffice(Model model) {
        model.addAttribute("offices", service.getOffices());
        return "office";
    }
}

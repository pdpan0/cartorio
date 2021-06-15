package com.lmmartins.cartorio.controllers;

import com.lmmartins.cartorio.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/certificates")
public class CertificatesController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping("/{officeId}")
    public String getCertificatesByOfficeId(Model model, @PathVariable("officeId") Long officeId) {
        model.addAttribute("certificates", certificateService.getCertificatesByOfficeId(officeId));
        return "certificate";
    }

    @GetMapping("/delete/{certificateId}")
    public String deleteCertificateById(@PathVariable("certificateId") Long certificateId) {
            certificateService.deleteCertificateById(certificateId);
        return "redirect:/certificates";
    }
}

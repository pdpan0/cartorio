package com.lmmartins.cartorio.controllers;

import com.lmmartins.cartorio.models.Certificate;
import com.lmmartins.cartorio.models.Office;
import com.lmmartins.cartorio.services.CertificateService;
import com.lmmartins.cartorio.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OfficeController {

    @Autowired
    private OfficeService officeService;
    @Autowired
    private CertificateService certificateService;

//  Rotas das telas
    @GetMapping
    public String getOffices(Model model) {
        model.addAttribute("offices", officeService.getOffices());
        return "office";
    }

    @GetMapping("/associate/{officeId}")
    public String getCertificatesToAssociate(Model model) {
        model.addAttribute("certificates", certificateService.getCertificates());
        return "certificate_form";
    }

    @GetMapping("/create")
    public String getOfficeFormForCreate(Model model) {
        model.addAttribute("office", new Office());
        return "office_form";
    }

    @GetMapping("/edit/{officeId}")
    public String getOfficeFormForEdit(Model model, @PathVariable Long officeId) {
        if(officeService.existOffice(officeId)) {
            model.addAttribute("office", officeService.getOfficeById(officeId));
            return "office_form_update";
        } else {
            return "redirect:/";
        }
    }

//  Ações do formulário.
    @PostMapping("/create")
    public String createOfficeSubmit(@ModelAttribute Office office) {
        officeService.createOffice(office);
        return "redirect:/";
    }

    @PostMapping("/associate/{officeId}")
    public String associateCertificate(@ModelAttribute Long certificateId, Long officeId) {
        certificateService.associateCertificate(certificateId, officeId);
        return "redirect:/";
    }

    @PostMapping("/edit/{officeId}")
    public String updateOfficeSubmit(@ModelAttribute Office office, @PathVariable Long officeId) {
        officeService.updateOfficeById(officeId,office);
        return "redirect:/";
    }
}

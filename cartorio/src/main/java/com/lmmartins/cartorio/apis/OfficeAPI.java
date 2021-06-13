package com.lmmartins.cartorio.apis;

import com.lmmartins.cartorio.models.Office;
import com.lmmartins.cartorio.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@Controller
@RestController
@RequestMapping("/v1/offices")
public class OfficeAPI {

    @Autowired
    private OfficeService service;

    @DeleteMapping("/{officeId}")
    public ResponseEntity deleteOffice(@PathVariable("officeId") Long officeId){
        return ok().build();
    }

    @GetMapping("/{officeId}")
    public ResponseEntity getOfficeById(@PathVariable("officeId") Long officeId){
        return ok().build();
    }

    @GetMapping
    public ResponseEntity getOffices(){
        return ok(service.getOffices());
    }

    @PostMapping
    public ResponseEntity createOffice(@RequestBody Office office){
        return ok(service.createOffice(office));
    }

    @PutMapping("/{officeId}")
    public ResponseEntity updateOfficeById(@PathVariable("officeId") Long officeId, @RequestBody Office office){
        return ok().build();
    }
}

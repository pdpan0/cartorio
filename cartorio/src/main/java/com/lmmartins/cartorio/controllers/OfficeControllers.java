package com.lmmartins.cartorio.controllers;

import com.lmmartins.cartorio.models.Office;
import com.lmmartins.cartorio.repositories.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v1/offices")
public class OfficeControllers {
    @Autowired
    private IOfficeRepository repository;

    @DeleteMapping("/{officeId}")
    public ResponseEntity deleteOffice(@PathVariable("officeId") Long officeId){
        repository.deleteById(officeId);
        return noContent().build();
    }

    @GetMapping("/{officeId}")
    public ResponseEntity getOfficeById(@PathVariable("officeId") Long officeId){
        Optional<Office> office = repository.findById(officeId);
        return ok().body(office);
    }

    @GetMapping
    public ResponseEntity getOffices(){
        List<Office> office = repository.findAll();
        return ok().body(office);
    }

    @PostMapping
    public ResponseEntity createOffice(@RequestBody Office office){
        Long officeId = repository.save(office).getId();
        return created(null).body(officeId);
    }

    @PutMapping("/{officeId}")
    public ResponseEntity updateOffice(@PathVariable("officeId") Long officeId, @RequestBody Office office){
        return ok().build();
    }
}

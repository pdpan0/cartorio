package com.lmmartins.cartorio.apis;

import com.lmmartins.cartorio.dto.CertificateDTO;
import com.lmmartins.cartorio.dto.Response;
import com.lmmartins.cartorio.models.Office;
import com.lmmartins.cartorio.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@Controller
@RestController
@RequestMapping("/v1/offices")
public class OfficeAPI {

    @Autowired
    private OfficeService service;

    @DeleteMapping("/{officeId}")
    public ResponseEntity deleteOffice(@PathVariable("officeId") Long officeId){
        Response response = service.deleteOfficeById(officeId);
        return response.getSuccess() ?
                ok().build() :
                status(response.getStatusCode()).body(response.getErrorMessage());
    }

    @GetMapping("/{officeId}")
    public ResponseEntity getOfficeById(@PathVariable("officeId") Long officeId){
        Office office = service.getOfficeById(officeId);
        return office.getId() == null ? noContent().build() : ok(office);
    }

    @GetMapping
    public ResponseEntity getOffices(){
        List<Office> offices = service.getOffices();
        return offices.isEmpty() ? noContent().build() : ok(offices);
    }

    @PostMapping
    public ResponseEntity createOffice(@RequestBody Office office){
        Response response = service.createOffice(office);
        return response.getSuccess() ?
                created(null).body("Office created with ID: "+ response.getObjectId()) :
                status(response.getStatusCode()).body(response.getErrorMessage());
    }

    @PutMapping("/{officeId}")
    public ResponseEntity updateOfficeById(@PathVariable("officeId") Long officeId, @RequestBody Office office){
        Response response = service.updateOfficeById(officeId, office);
        return response.getSuccess() ?
                ok().build() :
                status(response.getStatusCode()).body(response.getErrorMessage());
    }
}

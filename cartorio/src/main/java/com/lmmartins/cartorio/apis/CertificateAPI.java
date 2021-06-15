package com.lmmartins.cartorio.apis;

import com.lmmartins.cartorio.dto.CertificateDTO;
import com.lmmartins.cartorio.dto.Response;
import com.lmmartins.cartorio.interfaces.CertificateClient;
import com.lmmartins.cartorio.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v1/certificates")
public class CertificateAPI {
    @Autowired
    private CertificateClient client;
    @Autowired
    private CertificateService service;

    @DeleteMapping("/{certificateId}")
    public ResponseEntity deleteCertificateById(@PathVariable("certificateId") Long certificateId) {
        Response response = service.deleteCertificateById(certificateId);
        return response.getSuccess() ?
                ok().build() :
                status(response.getStatusCode()).body(response.getErrorMessage());
    }

    @GetMapping
    public ResponseEntity getCertificates() {
        List<CertificateDTO> certificates = client.getCertificates();
        return certificates.isEmpty() ? noContent().build() : ok(certificates);
    }

    @PostMapping("/{certificateId}/offices/{officeId}")
    public ResponseEntity associateCertificate(
            @PathVariable("certificateId") Long certificateId,
            @PathVariable("officeId") Long officeId
    ) {
        Response response = service.associateCertificate(certificateId, officeId);
        return response.getSuccess() ?
                ok().build() :
                status(response.getStatusCode()).body(response.getErrorMessage());
    }

}

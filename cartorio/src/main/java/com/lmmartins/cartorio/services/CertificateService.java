package com.lmmartins.cartorio.services;

import com.lmmartins.cartorio.dto.CertificateDTO;
import com.lmmartins.cartorio.dto.Response;
import com.lmmartins.cartorio.interfaces.CertificateClient;
import com.lmmartins.cartorio.models.Address;
import com.lmmartins.cartorio.models.Certificate;
import com.lmmartins.cartorio.models.Office;
import com.lmmartins.cartorio.repositories.ICertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {
    @Autowired
    private ICertificateRepository repository;
    @Autowired
    private OfficeService service;
    @Autowired
    private CertificateClient client;

    public List<CertificateDTO> getCertificates() {
        return client.getCertificates();
    }

    public List<Certificate> getCertificatesByOfficeId(Long officeId) {
        return repository.findAllCertificatesByOfficeId(officeId);
    }

    public Response deleteCertificateById(Long certificateId) {
        Optional<Certificate> certificate = repository.findById(certificateId);
        if (certificate.isEmpty()) {
            return new Response(false,404,"Not found the office.");
        }
        else {
            try {
                repository.deleteById(certificateId);
                return new Response(true,200, null);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new Response(false,500, "Internal error.");
            }
        }
    }

    public Response associateCertificate(Long certificateId, Long officeId) {
        try {
            Office office = service.getOfficeById(officeId);
            CertificateDTO certificateDTO = client.getCertificateById(certificateId);
            Certificate certificate = new Certificate(
                    null,
                    certificateDTO.getNome(),
                    office
            );
            repository.save(certificate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Response(false,500, "Internal error.");
        }
        return new Response(true, 200,null);
    }
}

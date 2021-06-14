package com.lmmartins.cartorio.services;

import com.lmmartins.cartorio.dto.CertificateDTO;
import com.lmmartins.cartorio.dto.Response;
import com.lmmartins.cartorio.interfaces.CertificateClient;
import com.lmmartins.cartorio.models.Certificate;
import com.lmmartins.cartorio.models.Office;
import com.lmmartins.cartorio.repositories.ICertificateRepository;
import com.lmmartins.cartorio.repositories.IOfficeRepository;
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

    public void associateCertificate(Long certificateId, Long officeId) {
        Office office = service.getOfficeById(officeId);
        CertificateDTO certificateDTO = client.getCertificateById(certificateId);
        Certificate certificate = new Certificate(
                null,
                certificateDTO.getNome(),
                office
        );
        repository.save(certificate);
    }
}

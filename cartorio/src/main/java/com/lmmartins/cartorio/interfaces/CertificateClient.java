package com.lmmartins.cartorio.interfaces;

import com.lmmartins.cartorio.dto.CertificateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
    Realiza a chamada no endpoint das certidões.
*/

@FeignClient(name = "certificates", url = "https://docketdesafiobackend.herokuapp.com/")
public interface CertificateClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/certidoes")
    List<CertificateDTO> getCertificates();

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/certidoes/{certificateId}")
    CertificateDTO getCertificateById(@PathVariable("certificateId") Long certificateId);
}

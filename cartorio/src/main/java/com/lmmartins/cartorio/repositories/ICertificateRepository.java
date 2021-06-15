package com.lmmartins.cartorio.repositories;

import com.lmmartins.cartorio.models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICertificateRepository extends JpaRepository<Certificate, Long> {
    @Query(
            value = "SELECT * FROM CERTIFICATE c WHERE c.office_id = :officeId",
            nativeQuery = true
    )
    List<Certificate> findAllCertificatesByOfficeId(@Param("officeId") Long officeId);
}

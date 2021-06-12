package com.lmmartins.cartorio.repositories;

import com.lmmartins.cartorio.models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICertificateRepository extends JpaRepository<Certificate, Long> {}

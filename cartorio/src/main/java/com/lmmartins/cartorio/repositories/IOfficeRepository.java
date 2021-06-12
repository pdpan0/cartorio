package com.lmmartins.cartorio.repositories;

import com.lmmartins.cartorio.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOfficeRepository extends JpaRepository<Office, Long> {}

package com.lmmartins.cartorio.repositories;

import com.lmmartins.cartorio.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {}

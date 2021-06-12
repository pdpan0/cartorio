package com.lmmartins.cartorio.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficeTest {
    @Test
    void createOffice() {
        Address address = new Address(
                null,
                "Vicente Pinzon",
                "Vila Olímpia",
                "São Paulo"
        );

        Office office = new Office(
                null,
                "Docket",
                address
        );

        System.out.println(address.toString());
        System.out.println(office.toString());

        assert office.getName() == "Docket";
    }
}
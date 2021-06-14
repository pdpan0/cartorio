package com.lmmartins.cartorio.services;

import com.lmmartins.cartorio.dto.Response;
import com.lmmartins.cartorio.models.Office;
import com.lmmartins.cartorio.repositories.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {
    @Autowired
    private IOfficeRepository repository;

    public Response deleteOfficeById(Long officeId) {
        Optional<Office> office = repository.findById(officeId);
        if (office.isEmpty()) {
            return new Response(false,404,"Not found the office.");
        }
        else {
            try {
                repository.deleteById(officeId);
                return new Response(true,200, null);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new Response(false,500, "Internal error.");
            }
        }
    }

    public Response updateOfficeById(Long officeId, Office office){
        Office newOffice = new Office(
                officeId,
                office.getName(),
                office.getAddress()
        );

        try {
            repository.save(newOffice);
            return new Response(true, 200, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Response(false, 500, null);
        }
    }

    public Response createOffice(Office office){
        try {
            return new Response(true, 200,null, repository.save(office).getId());
        } catch (Exception e) {
            return new Response(false, 500, null);
        }
    }

    public List<Office> getOffices(){
        try {
            return repository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public Office getOfficeById(Long officeId){
        try {
            return repository.findById(officeId).get();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean existOffice(Long officeId){
        try {
            return repository.existsById(officeId);
        } catch (Exception e) {
            return null;
        }
    }
}

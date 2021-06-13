package com.lmmartins.cartorio.services;

import com.lmmartins.cartorio.models.Office;
import com.lmmartins.cartorio.repositories.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {
    @Autowired
    private IOfficeRepository repository;

    public void deleteOfficeById(Long officeId){
//        Optional<Office> office = repository.findById(officeId);
//        if(office.isEmpty()) {
//            return notFound().build();
//        }
//        else {
            try {
                repository.deleteById(officeId);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
//        }
    }

    public void updateOfficeById(Long officeId, Office newOffice){
        Office updatedOffice = new Office(
                officeId,
                newOffice.getName(),
                newOffice.getAddress()
        );

        try {
            repository.save(updatedOffice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Long createOffice(Office office){
        try {
            return repository.save(office).getId();
        } catch (Exception e) {
            return null;
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
}

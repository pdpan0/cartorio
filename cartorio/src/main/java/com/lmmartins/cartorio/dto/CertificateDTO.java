package com.lmmartins.cartorio.dto;

import com.lmmartins.cartorio.models.Office;

import javax.persistence.*;

/*
    Classe responsável pela Certidão.
 */

public class CertificateDTO {
    private Long id;
    private String nome;

//  Construtores
    public CertificateDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

//  Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

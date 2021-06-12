package com.lmmartins.cartorio.models;

import javax.persistence.*;

/*
    Classe responsável pela Certidão.
 */

@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

//  Constructors
    public Certificate(Long id, String name, Office office) {
        this.id = id;
        this.name = name;
        this.office = office;
    }

//  Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", office=" + office +
                '}';
    }
}

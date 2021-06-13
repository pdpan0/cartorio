package com.lmmartins.cartorio.models;

import javax.persistence.*;

/*
    Classe responsável pelo Cartório.
 */

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "address_id")
    private Address address;

/*
    Configurações da coluna.
    cascade -> é utilizado para reduzir operações no H2.
*/

//  Constructors
    public Office() {}

    public Office(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

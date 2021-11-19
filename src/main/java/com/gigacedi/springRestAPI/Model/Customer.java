package com.gigacedi.springRestAPI.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    public Customer() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "customer")
    private CustomerRole customerRole;

    @Column (name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn (name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn (name = "em_Contact")
    private EmergencyContact emContact;

}






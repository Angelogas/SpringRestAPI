package com.gigacedi.springRestAPI.Model;

import javax.persistence.*;

@Entity
@Table(name ="customer_role")
public class CustomerRole {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name = "status")
    private Boolean status;

    @OneToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn (name = "role_id")
    private Role role;
}

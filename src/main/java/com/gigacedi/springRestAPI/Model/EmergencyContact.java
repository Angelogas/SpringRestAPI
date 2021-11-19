package com.gigacedi.springRestAPI.Model;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "emergency_contact")
@Data
public class EmergencyContact {

    @Id
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "phone")
    private String phone;

    @OneToMany (mappedBy = "emContact")
    private Set<Customer> customer;

}


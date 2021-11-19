package com.gigacedi.springRestAPI.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "address")
@Data
public class Address {

    @Id@GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "address_type")
    private AddressType addressType;

    @OneToMany (mappedBy = "address")
    private Set<Customer> customerSet;

    @Column (name = "street_name")
    private String streetName;

    @Column (name = "apt_or_suite_number")
    private int aptOrSuiteNumber;

    @Column (name = "city")
    private String city;

    @Column (name = "state")
    private String state;

    @Column (name = "zip_code")
    private String zipCode;

}


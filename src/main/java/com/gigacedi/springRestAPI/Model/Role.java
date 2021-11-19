package com.gigacedi.springRestAPI.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table (name ="role")
public class Role {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name = "role")
    private String role;

    @OneToMany(mappedBy = "role")
    private Set<CustomerRole> customerRole;


}

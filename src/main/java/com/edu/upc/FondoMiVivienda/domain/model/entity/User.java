package com.edu.upc.FondoMiVivienda.domain.model.entity;


import com.edu.upc.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(max = 150)
    private String name;


    @Size(max = 150)
    private String first_surname;

    @Size(max = 150)
    private String second_surname;


    private int age;

    @Size(max = 150)
    private String address;


    private int number_telephone;

    @Size(max = 150)
    private String nationality;


    private boolean bonus_good_payer;

    @Email
    private String email;


    private String password;
    


}

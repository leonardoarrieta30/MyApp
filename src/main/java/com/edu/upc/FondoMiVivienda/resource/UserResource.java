package com.edu.upc.FondoMiVivienda.resource;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Long id;
    private String name;
    private String first_surname;
    private String second_surname;
    private int age;
    private String address;
    private int number_telephone;
    private String nationality;
    private boolean bonus_good_payer;

    private String email;


    private String password;
}

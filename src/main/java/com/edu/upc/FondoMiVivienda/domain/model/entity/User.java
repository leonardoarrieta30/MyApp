package com.edu.upc.FondoMiVivienda.domain.model.entity;


import com.edu.upc.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Report> cuotas = new HashSet<>();

//    public User addReport(String ){
//
//    }
//


//    public List<Report> getReportes() {
//        return cuotas;
//    }

    public User addReport( String nroCuota, Number amortizacion, Number interes,
                           Number desgravamen, Number cuota, Number saldoInicial, Number saldoFinal){

        if(cuotas == null) {
            cuotas = new HashSet<>();
        }
//        cuotas.add(new Report());
        cuotas.add(new Report()
                .withNroCuota(nroCuota)
                .withAmortizacion(amortizacion)
                .withInteres(interes)
                .withDesgravamen(desgravamen)
                .withCuota(cuota)
                .withSaldoInicial(saldoInicial)
                .withSaldoFinal(saldoFinal)
                .withUser(this));
        return this;
    }
    public List<Report> getReportes() {
        List<Report> reportes = new ArrayList<>();

        for (Report cuota : cuotas) {
            Report reporte = new Report();
            reporte.setId(cuota.getId());
            reporte.setSaldoInicial(cuota.getSaldoInicial());
            reporte.setSaldoFinal(cuota.getSaldoFinal());
            reporte.setInteres(cuota.getInteres());
            reporte.setAmortizacion(cuota.getAmortizacion());
            reporte.setCuota(cuota.getCuota());
            reporte.setDesgravamen(cuota.getDesgravamen());
            reportes.add(reporte);
        }

        return reportes;
    }


}

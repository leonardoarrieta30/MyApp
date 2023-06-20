package com.edu.upc.FondoMiVivienda.domain.model.entity;


import com.edu.upc.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reports")
public class Report extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nroCuota;

    private Number amortizacion;

    private Number interes;

    private Number desgravamen;

    private Number cuota;

    private Number saldoInicial;

    private Number saldoFinal;

//
//    @Embedded
//    private EntidadEmbebida entidadEmbebida;


}



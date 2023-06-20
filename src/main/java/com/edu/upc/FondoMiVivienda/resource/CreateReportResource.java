package com.edu.upc.FondoMiVivienda.resource;


import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateReportResource {



    private String nroCuota;

    private Number amortizacion;

    private Number interes;

    private Number desgravamen;

    private Number cuota;

    private Number saldoInicial;

    private Number saldoFinal;
}


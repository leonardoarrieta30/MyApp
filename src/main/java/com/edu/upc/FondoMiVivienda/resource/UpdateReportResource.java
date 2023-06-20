package com.edu.upc.FondoMiVivienda.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateReportResource {
    private Long id;

    private String nroCuota;

    private Number amortizacion;

    private Number interes;

    private Number desgravamen;

    private Number cuota;

    private Number saldoInicial;

    private Number saldoFinal;
}

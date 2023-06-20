package com.edu.upc.FondoMiVivienda.domain.persistence;

import com.edu.upc.FondoMiVivienda.domain.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    Report findReportByNroCuota(String nroCuota);


}

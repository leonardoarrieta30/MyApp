package com.edu.upc.FondoMiVivienda.domain.persistence;

import com.edu.upc.FondoMiVivienda.domain.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    Report findReportByNroCuota(String nroCuota);

    List<Report> findByUserId(Long userId);

}

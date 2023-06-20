package com.edu.upc.FondoMiVivienda.service;

import com.edu.upc.FondoMiVivienda.domain.model.entity.Report;
import com.edu.upc.FondoMiVivienda.domain.persistence.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuotaService {
    @Autowired
    private ReportRepository reportRepository;

    public Report create(Report report) {
        return reportRepository.save(report);
    }
}

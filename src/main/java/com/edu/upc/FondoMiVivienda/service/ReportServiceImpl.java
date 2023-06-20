package com.edu.upc.FondoMiVivienda.service;


import com.edu.upc.FondoMiVivienda.domain.model.entity.Report;
import com.edu.upc.FondoMiVivienda.domain.persistence.ReportRepository;
import com.edu.upc.FondoMiVivienda.domain.service.ReportService;
import com.edu.upc.shared.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ReportServiceImpl implements ReportService {

    private static final String ENTITY = "Report";
    private final ReportRepository reportRepository;

    private final Validator validator;

    public ReportServiceImpl(ReportRepository reportRepository, Validator validator) {
        this.reportRepository = reportRepository;
        this.validator = validator;
    }

    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public Page<Report> getAll(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }

    @Override
    public Report getById(Long reportId) {
        return reportRepository.findById(reportId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, reportId));
    }

    @Override
    public Report create(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report update(Long reportId, Report request) {
        Set<ConstraintViolation<Report>> violations = validator.validate((request));
        return reportRepository.findById(reportId).map(report ->
                        reportRepository.save(
                                        report.withCuota(request.getCuota())
                                                .withAmortizacion(request.getAmortizacion())
                                                .withInteres(request.getInteres())
                                                .withDesgravamen(request.getDesgravamen())
                                                .withCuota(request.getCuota())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, reportId));
    }

    @Override
    public ResponseEntity<?> delete(Long reportId) {
        return reportRepository.findById(reportId).map(report -> {
            reportRepository.delete(report);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, reportId));
    }
}

package com.edu.upc.FondoMiVivienda.domain.service;

import com.edu.upc.FondoMiVivienda.domain.model.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportService {

    List<Report> getAll();

    Page<Report> getAll(Pageable pageable);

    Report getById(Long reportId);

    Report create(Report report);

    Report update(Long reportId, Report request);

    ResponseEntity<?> delete(Long reportId);

}

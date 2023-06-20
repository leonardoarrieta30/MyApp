package com.edu.upc.FondoMiVivienda.api;

import com.edu.upc.FondoMiVivienda.domain.model.entity.Report;
import com.edu.upc.FondoMiVivienda.domain.persistence.ReportRepository;
import com.edu.upc.FondoMiVivienda.domain.service.ReportService;
import com.edu.upc.FondoMiVivienda.mapping.ReportMapper;
import com.edu.upc.FondoMiVivienda.resource.*;
import com.edu.upc.FondoMiVivienda.service.CuotaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/cuota", produces = "application/json")
@Tag(name = "Reports", description = "Create, read, update and delete reports")
public class ReportsController {
    private final ReportService reportService;
    private final CuotaService cuotaService;
    private final ReportRepository repository;
    private final ReportMapper mapper;

    public ReportsController(ReportService reportService, CuotaService cuotaService, ReportRepository repository, ReportMapper mapper) {
        this.reportService = reportService;
        this.cuotaService = cuotaService;
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ReportResource> getAllReports(Pageable pageable) {
        return mapper.modelListPage(reportService.getAll(), pageable);
    }

    @GetMapping("{reportId}")
    public ReportResource getReportById(@PathVariable Long reportId){
        return mapper.toResource(reportService.getById(reportId));
    }

    @PostMapping
    public ResponseEntity<ReportResource> createReport(@RequestBody CreateReportResource resource){
        return new ResponseEntity<>(mapper.toResource(reportService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

//    @PostMapping("/cuotas")
//    public ResponseEntity<> crearEntidad(@RequestBody CreateCuotaResource entidad) {
//        // Realizar validaciones y operaciones necesarias
//
//        Report entidadGuardada = repository.save(entidad);
//
//        return new ResponseEntity<>(mapper.toResource(cuotaService.create(mapper.toModel(entidad))), HttpStatus.CREATED);
//
//        return ResponseEntity.ok(entidadGuardada);
//    }


    @PutMapping("{reportId}")
    public ReportResource updateReport(@PathVariable Long reportId, @RequestBody UpdateReportResource resource){
        return mapper.toResource(reportService.update(reportId, mapper.toModel(resource)));
    }

    @DeleteMapping("{reportId}")
    public ResponseEntity<?> deleteReport(@PathVariable Long reportId) {
        return reportService.delete(reportId);
    }



}

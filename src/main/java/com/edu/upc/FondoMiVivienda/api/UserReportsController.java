package com.edu.upc.FondoMiVivienda.api;

import com.edu.upc.FondoMiVivienda.domain.persistence.UserRepository;
import com.edu.upc.FondoMiVivienda.domain.service.ReportService;
import com.edu.upc.FondoMiVivienda.domain.service.UserService;
import com.edu.upc.FondoMiVivienda.mapping.ReportMapper;
import com.edu.upc.FondoMiVivienda.resource.CreateReportResource;
import com.edu.upc.FondoMiVivienda.resource.ReportResource;
import com.edu.upc.shared.exception.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users/{userId}/reports", produces = "application/json")
@Tag(name = "Users", description = "Create, read, update and delete skills")
public class UserReportsController {
    private static final String ENTITY = "User";
    private final ReportService reportService;

    private final UserService userService;
    private final UserRepository userRepository;
    private final ReportMapper mapper;

    public UserReportsController(ReportService reportService, UserService userService, UserRepository userRepository, ReportMapper mapper) {
        this.reportService = reportService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ReportResource> getAllCriteriaBySkillId(@PathVariable Long userId,
                                                        Pageable pageable) {
        return mapper.modelListPage(userService.getById(userId).getCuotas().stream().toList(), pageable);
    }

    @PostMapping
    public ReportResource createReport(@PathVariable Long userId,
                                             @RequestBody CreateReportResource resource) {

        userService.addReportToUser(userId, resource.getNroCuota(),resource.getAmortizacion(),resource.getInteres(),
                resource.getDesgravamen(),resource.getCuota(),resource.getSaldoInicial(),resource.getSaldoFinal());


        return null;
    }
}

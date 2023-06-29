package com.edu.upc.FondoMiVivienda.service;

import com.edu.upc.FondoMiVivienda.domain.model.entity.Report;
import com.edu.upc.FondoMiVivienda.domain.model.entity.User;
import com.edu.upc.FondoMiVivienda.domain.persistence.UserRepository;
import com.edu.upc.FondoMiVivienda.domain.service.UserService;
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
public class UserServiceImpl implements UserService {

    private static final String ENTITY = "User";
    private final UserRepository userRepository;

    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,userId));
    }

    @Override
    public User create(User user) {

        return userRepository.save(user);

    }

    @Override
    public User update(Long userId, User request) {
        Set<ConstraintViolation<User>> violations = validator.validate((request));
        return userRepository.findById(userId).map(user ->
                        userRepository.save(
                                        user.withName(request.getName())
                                        .withFirst_surname(request.getFirst_surname())
                                        .withSecond_surname(request.getSecond_surname())
                                        .withAge(request.getAge())
                                        .withAddress(request.getAddress())
                                        .withNumber_telephone(request.getNumber_telephone())
                                        .withNationality(request.getNationality())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User addReportToUser(Long userId, String nroCuota, Number amortizacion, Number interes,
                                Number desgravamen, Number cuota, Number saldoInicial, Number saldoFinal) {
        return userRepository.findById(userId).map(skill -> {
            return userRepository.save(skill.addReport(nroCuota, amortizacion, interes, desgravamen,cuota, saldoInicial, saldoFinal));
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

}

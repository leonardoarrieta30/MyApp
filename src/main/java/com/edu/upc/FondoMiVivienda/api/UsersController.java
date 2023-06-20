package com.edu.upc.FondoMiVivienda.api;

import com.edu.upc.FondoMiVivienda.domain.model.entity.Report;
import com.edu.upc.FondoMiVivienda.domain.model.entity.User;
import com.edu.upc.FondoMiVivienda.domain.persistence.ReportRepository;
import com.edu.upc.FondoMiVivienda.domain.persistence.UserRepository;
import com.edu.upc.FondoMiVivienda.domain.service.UserService;
import com.edu.upc.FondoMiVivienda.mapping.UserMapper;
import com.edu.upc.FondoMiVivienda.resource.CreateUserResource;
import com.edu.upc.FondoMiVivienda.resource.UpdateUserResource;
import com.edu.upc.FondoMiVivienda.resource.UserResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/users", produces = "application/json")
@Tag(name = "Users", description = "Create, read, update and delete users")
public class UsersController {
    private final UserService userService;
    private final UserMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReportRepository reportRepository;
    public UsersController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

//    @PostMapping("/{userId}/reportes")
//    public void guardarReporteParaUsuario(@PathVariable Long userId, @RequestBody Report reporte) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
//
//        reporte.setUsuario(user);
//        // Realiza otras operaciones o validaciones necesarias
//        // Guarda el reporte en la base de datos
//    }

//    @PostMapping("/reports")
//    public void guardarUsuarioConReportes(@RequestBody User usuario) {
//        // Guarda el usuario en la base de datos
////        User usuarioGuardado = userRepository.save(usuario);
//
//        // Asigna el usuario correspondiente a cada reporte
//        //            reporte.setUsuario(usuarioGuardado);
//        reportRepository.saveAll(usuario.getReportes());
//    }


    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable) {
        return mapper.modelListPage(userService.getAll(), pageable);
    }

    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable Long userId){
        return mapper.toResource(userService.getById(userId));
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource){
        return new ResponseEntity<>(mapper.toResource(userService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    public UserResource updateUser(@PathVariable Long userId, @RequestBody UpdateUserResource resource){
        return mapper.toResource(userService.update(userId, mapper.toModel(resource)));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.delete(userId);
    }
}

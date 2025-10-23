package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.adapter.in.builder.UserBuilder;
import app.adapter.in.rest.request.UserRequest;
import app.application.exceptions.BusinessException;
import app.application.exceptions.InputsException;
import app.domain.model.User;
import app.application.usecases.HumanUseCase;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    
    @Autowired
    private UserBuilder userBuilder;
    
    @Autowired
    private HumanUseCase humanUseCase;

    @PostMapping("/doctors")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createDoctor(@RequestBody UserRequest request) {
        try {
            User user = userBuilder.build(
                    request.getName(),
                    request.getDocument(),
                    request.getAge(),
                    request.getUserName(),
                    request.getPassword()
            );

            humanUseCase.createDoctor(user);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Doctor creado exitosamente");

        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/nurses")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createNurse(@RequestBody UserRequest request) {
        try {
            User user = userBuilder.build(
                    request.getName(),
                    request.getDocument(),
                    request.getAge(),
                    request.getUserName(),
                    request.getPassword()
            );

            humanUseCase.createNurse(user);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Enfermera creada exitosamente");

        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/support")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createSupport(@RequestBody UserRequest request) {
        try {
            User user = userBuilder.build(
                    request.getName(),
                    request.getDocument(),
                    request.getAge(),
                    request.getUserName(),
                    request.getPassword()
            );

            humanUseCase.createSupport(user);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Personal de soporte creado exitosamente");

        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/admins")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createAdmin(@RequestBody UserRequest request) {
        try {
            User user = userBuilder.build(
                    request.getName(),
                    request.getDocument(),
                    request.getAge(),
                    request.getUserName(),
                    request.getPassword()
            );

            humanUseCase.createAdmin(user);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Administrador creado exitosamente");

        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
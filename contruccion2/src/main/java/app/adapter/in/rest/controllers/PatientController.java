package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import app.application.exceptions.BusinessException;
import app.application.exceptions.InputsException;
import app.application.usecases.AdminUseCase;

import java.util.Map;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private AdminUseCase adminUseCase;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createPatient(@RequestBody Map<String, String> request) throws BusinessException, InputsException {
        try {

            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Paciente creado exitosamente");
                    
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear paciente: " + e.getMessage());
        }
    }

    @GetMapping("/{patientId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'DOCTOR', 'NURSE')")
    public ResponseEntity<?> getPatient(@PathVariable String patientId) {
        try {
           
            return ResponseEntity.ok("Información del paciente " + patientId);
            
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Paciente no encontrado");
        }
    }

    @PutMapping("/{patientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updatePatient(
            @PathVariable String patientId,
            @RequestBody Map<String, String> request) {
        try {
            return ResponseEntity.ok("Paciente actualizado exitosamente");
            
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar paciente: " + e.getMessage());
        }
    }
}
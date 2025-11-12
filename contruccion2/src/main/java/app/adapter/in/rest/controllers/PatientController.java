package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.rest.request.PatientRequest;
import app.application.exceptions.BusinessException;
import app.application.exceptions.InputsException;
import app.application.usecases.AdminUseCase;
import app.domain.model.Patient;
import app.domain.model.User;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private AdminUseCase adminUseCase;
    
    @Autowired
    private PatientBuilder patientBuilder;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest request) {
        try {
            
            Patient patient = patientBuilder.build(
                request.getDocument(), 
                request.getGender(),
                request.getFullName(),
                request.getAddress(),
                request.getPhoneNumber(),
                request.getEmail(),
                request.getAge(),
                request.getEmergencyContactName(),
                request.getRelationship(),
                request.getEmergencyPhoneNumber(),
                request.getInsuranceCompany(),
                request.getPolicyNumber(),
                request.getPolicyStatus(),
                request.getPolicyEndDate()
            );

            // Convertir Patient a User con el ID/document
            User userPatient = new User();
            userPatient.setId(patient.getId());  // ID ES EL DOCUMENT
            userPatient.setFullName(patient.getFullName());
            userPatient.setAge(patient.getAge());
            userPatient.setEmail(patient.getEmail());
            userPatient.setAddress(patient.getAddress());
            userPatient.setPhone(patient.getPhone());

            adminUseCase.createPatient(userPatient);
            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Paciente creado exitosamente con documento: " + patient.getId());
                    
        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());
                    
        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(be.getMessage());
                    
        } catch (Exception e) {
            e.printStackTrace();
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
            @RequestBody PatientRequest request) {
        try {
            return ResponseEntity.ok("Paciente actualizado exitosamente");
            
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar paciente: " + e.getMessage());
        }
    }
}
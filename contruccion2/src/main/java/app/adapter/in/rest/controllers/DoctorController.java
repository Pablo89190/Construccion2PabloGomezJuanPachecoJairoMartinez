package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import app.adapter.in.builder.ClinicalOrderBuilder;
import app.adapter.in.builder.ClinicalRecordBuilder;
import app.application.exceptions.BusinessException;
import app.application.exceptions.InputsException;
import app.application.usecases.DoctorUseCase;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.DiagnosticOrder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctor")
@PreAuthorize("hasRole('DOCTOR')")
public class DoctorController {

    @Autowired
    private DoctorUseCase doctorUseCase;
    
    @Autowired
    private ClinicalOrderBuilder clinicalOrderBuilder;
    
    @Autowired
    private ClinicalRecordBuilder clinicalRecordBuilder;

    @GetMapping("/records/patient/{patientId}")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> searchRecordsByPatient(@PathVariable String patientId) {
        try {
            app.domain.model.Patient patient = new app.domain.model.Patient();
            patient.setId(Long.parseLong(patientId));
            
            List<ClinicalRecord> records = doctorUseCase.searchRecords(patient);
            return ResponseEntity.ok(records);
            
        } catch (NumberFormatException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("ID de paciente inválido");
                    
        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(be.getMessage());
                    
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar registros: " + e.getMessage());
        }
    }

    // Crear historia clínica
    @PostMapping("/records")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> createClinicalRecord(@RequestBody Map<String, String> request) {
        try {
            String patientId = request.get("patientId");
            String doctorId = request.get("doctorId");
            String clinicalOrderId = request.get("clinicalOrderId");
            
            ClinicalRecord record = clinicalRecordBuilder.build(
                patientId, 
                doctorId, 
                clinicalOrderId
            );
            
            doctorUseCase.createClinicalRecord(record);
            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Historia clínica creada exitosamente");
                    
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
                    .body("Error al crear historia clínica: " + e.getMessage());
        }
    }

    // Crear orden clínica
    @PostMapping("/orders")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> createClinicalOrder(@RequestBody Map<String, String> request) {
        try {
            String doctorId = request.get("doctorId");
            String patientId = request.get("patientId");
            String orderType = request.get("orderType");
            
            ClinicalOrder order = clinicalOrderBuilder.buildBasicOrder(
                doctorId, 
                patientId, 
                orderType
            );
            
            doctorUseCase.createClinicalOrder(order);
            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Orden clínica creada exitosamente");
                    
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
                    .body("Error al crear orden: " + e.getMessage());
        }
    }


    @PostMapping("/orders/diagnostic")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> createDiagnosticOrder(@RequestBody Map<String, String> request) {
        try {
            String doctorId = request.get("doctorId");
            String patientId = request.get("patientId");
            String examType = request.get("examType");
            String quantity = request.get("quantity");
            String cost = request.get("cost");
            
            DiagnosticOrder order = clinicalOrderBuilder.buildDiagnosticOrder(
                doctorId, 
                patientId, 
                examType, 
                quantity, 
                cost
            );
            
            doctorUseCase.createDiagnosticOrder(order);
            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Orden diagnóstica creada exitosamente");
                    
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
                    .body("Error al crear orden diagnóstica: " + e.getMessage());
        }
    }
}
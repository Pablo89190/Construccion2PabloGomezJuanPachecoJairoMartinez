package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import app.adapter.in.builder.ClinicalOrderBuilder;
import app.adapter.in.builder.ClinicalRecordBuilder;
import app.adapter.in.builder.RegistrationAttentionBuilder;
import app.application.exceptions.BusinessException;
import app.application.exceptions.InputsException;
import app.application.usecases.DoctorUseCase;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.DiagnosticOrder;
import app.domain.model.RegistrationAttention;

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
    
    @Autowired
    private RegistrationAttentionBuilder registrationAttentionBuilder;

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

    @PostMapping("/records")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> createClinicalRecord(@RequestBody Map<String, String> request) {
        try {
            String patientId = request.get("patientId");
            String doctorId = request.get("doctorId");
            String clinicalOrderId = request.get("clinicalOrderId");
            
            if (clinicalOrderId == null || clinicalOrderId.trim().isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("clinicalOrderId es requerido. Uso: POST /api/doctor/records");
            }
            
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

    @PostMapping("/orders")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> createClinicalOrder(@RequestBody Map<String, String> request) {
        try {
            String doctorId = request.get("doctorId");
            String patientId = request.get("patientId");
            String orderType = request.get("orderType");
            
            if (request.containsKey("cost")) {
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Las órdenes MEDICINE y PROCEDURE NO incluyen 'cost'. Use /orders/diagnostic para incluir costo");
            }
            
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
            
            if (cost == null || cost.trim().isEmpty()) {
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("El campo 'cost' es obligatorio para órdenes diagnósticas");
            }
            
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

    @PostMapping("/attentions")
    @PreAuthorize("hasRole('DOCTOR')")
    public ResponseEntity<?> registerMedicalAttention(@RequestBody Map<String, String> request) {
        try {
            String patientId = request.get("patientId");
            String doctorId = request.get("doctorId");
            String reason = request.get("reason");
            String symptoms = request.get("symptoms");
            String diagnosis = request.get("diagnosis");
            
            RegistrationAttention attention = registrationAttentionBuilder.build(
                patientId,
                doctorId,
                reason,
                symptoms,
                diagnosis
            );
            
            doctorUseCase.addAttentionToRecord(patientId, "attention_" + System.currentTimeMillis(), attention);
            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Atención médica registrada exitosamente");
                    
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
                    .body("Error al registrar atención: " + e.getMessage());
        }
    }
}
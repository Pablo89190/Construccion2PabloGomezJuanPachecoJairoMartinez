package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import app.adapter.in.builder.VitalDataBuilder;
import app.adapter.in.rest.request.NurseAttentionRequest;
import app.adapter.in.rest.request.ProcedureRequest;
import app.adapter.in.rest.request.VitalDataRequest;
import app.adapter.in.builder.RegistrationAttentionBuilder;
import app.adapter.in.builder.ProcedureBuilder;
import app.application.exceptions.BusinessException;
import app.application.exceptions.InputsException;
import app.application.usecases.NurseUseCase;
import app.domain.model.VitalData;
import app.domain.model.RegistrationAttention;
import app.domain.model.Procedure;

@RestController
@RequestMapping("/api/nurse")
@PreAuthorize("hasRole('NURSE')")
public class NurseController {

    @Autowired
    private NurseUseCase nurseUseCase;
    
    @Autowired
    private VitalDataBuilder vitalDataBuilder;
    
    @Autowired
    private RegistrationAttentionBuilder registrationAttentionBuilder;
    
    @Autowired
    private ProcedureBuilder procedureBuilder;

    // Registrar signos vitales
    @PostMapping("/vital-data")
    @PreAuthorize("hasRole('NURSE')")
    public ResponseEntity<?> registerVitalData(@RequestBody VitalDataRequest request) {
        try {
            VitalData vitalData = vitalDataBuilder.build(
                    request.getBloodPressure(),
                    request.getTemperature(),
                    request.getPulserate(),
                    request.getBloodOxygenLevel()
            );
            
            nurseUseCase.registerVitalData(vitalData);
            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Signos vitales registrados exitosamente");
                    
        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());
                    
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

   
    @PostMapping("/attentions")
    @PreAuthorize("hasRole('NURSE')")
    public ResponseEntity<?> registerAttention(@RequestBody NurseAttentionRequest request) {
        try {
            RegistrationAttention attention = registrationAttentionBuilder.buildNurseAttention(
                    request.getPatientId(),
                    request.getReason(),
                    request.getSymptoms()
            );
            
            VitalData vitalData = vitalDataBuilder.build(
                    request.getBloodPressure(),
                    request.getTemperature(),
                    request.getPulserate(),
                    request.getBloodOxygenLevel()
            );
            
            nurseUseCase.registerAttention(request.getPatientId(), attention, vitalData);
            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Atención de enfermería registrada exitosamente");
                    
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

    @PostMapping("/procedures")
    @PreAuthorize("hasRole('NURSE')")
    public ResponseEntity<?> createProcedure(@RequestBody ProcedureRequest request) {
        try {
            Procedure procedure = procedureBuilder.buildGeneral(
                    request.getName(),
                    request.getTimes(),
                    request.getFrequency(),
                    request.getCost()
            );
            
            nurseUseCase.createOrder(procedure);
            
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Procedimiento creado exitosamente");
                    
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
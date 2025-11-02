package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import app.adapter.in.builder.MedicineBuilder;
import app.adapter.in.builder.ProcedureBuilder;
import app.adapter.in.rest.request.MedicineRequest;
import app.adapter.in.rest.request.ProcedureDetailRequest;
import app.application.exceptions.BusinessException;
import app.application.exceptions.InputsException;
import app.application.usecases.SupportUseCase;
import app.domain.model.Medicine;
import app.domain.model.Procedure;

@RestController
@RequestMapping("/api/support")
@PreAuthorize("hasRole('SUPPORT')")
public class SupportController {

    @Autowired
    private SupportUseCase supportUseCase;
    
    @Autowired
    private MedicineBuilder medicineBuilder;
    
    @Autowired
    private ProcedureBuilder procedureBuilder;

    // Gestión de Medicinas
    @PostMapping("/medicines")
    @PreAuthorize("hasRole('SUPPORT')")
    public ResponseEntity<?> createMedicine(@RequestBody MedicineRequest request) {
        try {
            Medicine medicine = medicineBuilder.build(
                    request.getMedicineId(),
                    request.getName(),
                    request.getDoce(),
                    request.getDuration(),
                    request.getCost()
            );

            supportUseCase.createMedicine(medicine);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Medicamento creado exitosamente");

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
                    .body("Error al crear medicamento: " + e.getMessage());
        }
    }

    @PutMapping("/medicines/{medicineId}")
    @PreAuthorize("hasRole('SUPPORT')")
    public ResponseEntity<?> updateMedicine(
            @PathVariable String medicineId,
            @RequestBody MedicineRequest request) {
        try {
            Medicine medicine = medicineBuilder.buildForUpdate(
                    medicineId,
                    request.getName(),
                    request.getDoce(),
                    request.getDuration(),
                    request.getCost()
            );

            supportUseCase.updateMedicine(medicine);

            return ResponseEntity.ok("Medicamento actualizado exitosamente");

        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar medicamento: " + e.getMessage());
        }
    }

    @DeleteMapping("/medicines/{medicineId}")
    @PreAuthorize("hasRole('SUPPORT')")
    public ResponseEntity<?> deleteMedicine(@PathVariable String medicineId) {
        try {
            Medicine medicine = new Medicine();
            medicine.setMedicineId(medicineId);

            supportUseCase.deleteMedicine(medicine);

            return ResponseEntity.ok("Medicamento eliminado exitosamente");

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar medicamento: " + e.getMessage());
        }
    }

    // Gestión de Procedimientos
    @PostMapping("/procedures")
    @PreAuthorize("hasRole('SUPPORT')")
    public ResponseEntity<?> createProcedure(@RequestBody ProcedureDetailRequest request) {
        try {
            Procedure procedure = procedureBuilder.build(
                    request.getName(),
                    request.getTimes(),
                    request.getFrequency(),
                    request.getRequiresSpecialist(),
                    request.getSpecialty(),
                    request.getCost()
            );

            supportUseCase.createProcedure(procedure);

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
                    .body("Error al crear procedimiento: " + e.getMessage());
        }
    }

    @PutMapping("/procedures/{procedureName}")
    @PreAuthorize("hasRole('SUPPORT')")
    public ResponseEntity<?> updateProcedure(
            @PathVariable String procedureName,
            @RequestBody ProcedureDetailRequest request) {
        try {
            Procedure procedure = procedureBuilder.buildForUpdate(
                    procedureName,
                    request.getTimes(),
                    request.getFrequency(),
                    request.getRequiresSpecialist(),
                    request.getSpecialty(),
                    request.getCost()
            );

            supportUseCase.updateProcedure(procedure);

            return ResponseEntity.ok("Procedimiento actualizado exitosamente");

        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar procedimiento: " + e.getMessage());
        }
    }

    @DeleteMapping("/procedures/{procedureName}")
    @PreAuthorize("hasRole('SUPPORT')")
    public ResponseEntity<?> deleteProcedure(@PathVariable String procedureName) {
        try {
            Procedure procedure = new Procedure();
            procedure.setName(procedureName);

            supportUseCase.deleteProcedure(procedure);

            return ResponseEntity.ok("Procedimiento eliminado exitosamente");

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar procedimiento: " + e.getMessage());
        }
    }
}
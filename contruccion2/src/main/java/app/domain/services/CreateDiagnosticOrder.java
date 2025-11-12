package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.ports.DiagnosticOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

@Service
public class CreateDiagnosticOrder {
    
    @Autowired
    private DiagnosticOrderPort diagnosticOrderPort;
    
    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private UserPort userPort;

    public CreateDiagnosticOrder(DiagnosticOrderPort diagnosticOrderPort, 
                                PatientPort patientPort,
                                UserPort userPort) {
        this.diagnosticOrderPort = diagnosticOrderPort;
        this.patientPort = patientPort;
        this.userPort = userPort;
    }

    public void create(DiagnosticOrder order) throws Exception {
        System.out.println("CREANDO ORDEN DIAGNÓSTICA");
        
        Patient patient = patientPort.findById(order.getPatient().getId());
        if (patient == null) {
            throw new Exception("El paciente no existe en el sistema. Documento: " + order.getPatient().getId());
        }
        System.out.println("Paciente encontrado: " + patient.getFullName());
        

        User doctor = null;

        if (order.getDoctor().getId() > 0) {
            System.out.println("🔍 Buscando doctor por documento: " + order.getDoctor().getId());
            doctor = userPort.findByDocument(order.getDoctor().getId());
        }

        else if (order.getDoctor().getUsername() != null) {
            System.out.println("🔍 Buscando doctor por username: " + order.getDoctor().getUsername());
            doctor = userPort.findByUserName(order.getDoctor().getUsername());
        }
        

        if (doctor == null) {
            throw new Exception("El doctor no existe en el sistema. Documento: " + order.getDoctor().getId());
        }
        
        if (!doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("Solo los médicos pueden crear órdenes diagnósticas. Rol actual: " + doctor.getRole());
        }
        
        System.out.println("Doctor encontrado: " + doctor.getFullName() + " (Rol: " + doctor.getRole() + ")");
        

        order.setPatient(patient);
        order.setDoctor(doctor);
        
     
        diagnosticOrderPort.save(order);
        
        System.out.println("✅ Orden diagnóstica creada exitosamente");
        System.out.println("   - ID: " + order.getId());
        System.out.println("   - Examen: " + order.getExam());
        System.out.println("   - Cantidad: " + order.getQuantity());
        System.out.println("   - Costo: " + order.getCost());
        System.out.println("FIN CREACIÓN ORDEN DIAGNÓSTICA \n");
    }
}
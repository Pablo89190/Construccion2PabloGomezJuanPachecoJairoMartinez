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
        System.out.println("INICIANDO CREACIÓN DE ORDEN DIAGNÓSTICA");
        
        System.out.println("PASO 1: Validando paciente...");
        Patient patient = patientPort.findById(order.getPatient().getId());
        if (patient == null) {
            System.err.println("❌ PACIENTE NO ENCONTRADO");
            throw new Exception("❌ El paciente con documento " + order.getPatient().getId() + 
                              " NO existe en el sistema. Debe crear el paciente primero.");
        }
        System.out.println("✅ Paciente validado: " + patient.getFullName());
        
        System.out.println("📋 PASO 2: Validando doctor...");
        User doctor = null;

        if (order.getDoctor().getId() > 0) {
            System.out.println("🔍 Buscando doctor por documento: " + order.getDoctor().getId());
            doctor = userPort.findByDocument(order.getDoctor().getId());
        }

        else if (order.getDoctor().getUsername() != null && !order.getDoctor().getUsername().isEmpty()) {
            System.out.println("🔍 Buscando doctor por username: " + order.getDoctor().getUsername());
            doctor = userPort.findByUserName(order.getDoctor().getUsername());
        }

        if (doctor == null) {
            System.err.println("DOCTOR NO ENCONTRADO");
            throw new Exception(" El doctor con documento/usuario " + order.getDoctor().getId() + 
                              " NO existe en el sistema.");
        }
        
        if (!doctor.getRole().equals(Role.DOCTOR)) {
            System.err.println("USUARIO NO ES DOCTOR");
            throw new Exception(" Solo los médicos pueden crear órdenes diagnósticas. Rol actual: " + doctor.getRole());
        }
        
        System.out.println("Doctor validado: " + doctor.getFullName() + " (Rol: " + doctor.getRole() + ")");
        

        System.out.println("PASO 3: Asignando objetos persistidos...");
        order.setPatient(patient);
        order.setDoctor(doctor);
        System.out.println("Objetos asignados correctamente");
        
     
        System.out.println(" PASO 4: Guardando orden en base de datos...");
        diagnosticOrderPort.save(order);
        
        System.out.println("ORDEN DIAGNÓSTICA CREADA EXITOSAMENTE");
        System.out.println("ID: " + order.getId());
        System.out.println("Paciente: " + patient.getFullName());
        System.out.println("Doctor: " + doctor.getFullName());
        System.out.println("Examen: " + order.getExam());
        System.out.println("Cantidad: " + order.getQuantity());
        System.out.println("Costo: $" + order.getCost());
        System.out.println("FIN CREACIÓN ORDEN DIAGNÓSTICA\n");
    }
}
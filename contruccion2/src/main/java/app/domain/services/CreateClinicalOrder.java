package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

@Service
public class CreateClinicalOrder {
    
    @Autowired
    private UserPort userPort;
    
    @Autowired
    private PatientPort patientPort;
    
    @Autowired
    private ClinicalOrderPort clinicalOrderPort;

    public CreateClinicalOrder(UserPort userPort, PatientPort patientPort, ClinicalOrderPort clinicalOrderPort) {
        this.userPort = userPort;
        this.patientPort = patientPort;
        this.clinicalOrderPort = clinicalOrderPort;
    }
    
    public void create(ClinicalOrder clinicalOrder) throws Exception {
        System.out.println("🔄 === INICIANDO CREACIÓN DE ORDEN CLÍNICA ===");
        
        // ✅ PASO 1: Validar que el PACIENTE EXISTE en BD
        System.out.println("📋 PASO 1: Validando paciente...");
        Patient patient = patientPort.findById(clinicalOrder.getPatient().getId());
        if (patient == null) {
            System.err.println("❌ PACIENTE NO ENCONTRADO");
            throw new Exception("❌ El paciente con documento " + clinicalOrder.getPatient().getId() + 
                              " NO existe en el sistema. Debe crear el paciente primero.");
        }
        System.out.println("✅ Paciente validado: " + patient.getFullName());
        
        // ✅ PASO 2: Validar que el DOCTOR EXISTE y tiene rol DOCTOR
        System.out.println("📋 PASO 2: Validando doctor...");
        User doctor = null;

        if (clinicalOrder.getDoctor().getId() > 0) {
            System.out.println("🔍 Buscando doctor por documento: " + clinicalOrder.getDoctor().getId());
            doctor = userPort.findByDocument(clinicalOrder.getDoctor().getId());
        } 
        else if (clinicalOrder.getDoctor().getUsername() != null && !clinicalOrder.getDoctor().getUsername().isEmpty()) {
            System.out.println("🔍 Buscando doctor por username: " + clinicalOrder.getDoctor().getUsername());
            doctor = userPort.findByUserName(clinicalOrder.getDoctor().getUsername());
        }

        if (doctor == null) {
            System.err.println("❌ DOCTOR NO ENCONTRADO");
            throw new Exception("❌ El doctor NO existe en el sistema");
        }
        
        if (!doctor.getRole().equals(Role.DOCTOR)) {
            System.err.println("❌ USUARIO NO ES DOCTOR");
            throw new Exception("❌ Las órdenes solo las pueden crear los Médicos. Rol actual: " + doctor.getRole());
        }
        
        System.out.println("✅ Doctor validado: " + doctor.getFullName() + " (Rol: " + doctor.getRole() + ")");

        // ✅ PASO 3: Asignar objetos persistidos a la orden
        System.out.println("📋 PASO 3: Asignando objetos persistidos...");
        clinicalOrder.setPatient(patient);
        clinicalOrder.setDoctor(doctor);
        System.out.println("✅ Objetos asignados correctamente");
        
        // ✅ PASO 4: Guardar la orden en BD
        System.out.println("📋 PASO 4: Guardando orden en base de datos...");
        clinicalOrderPort.save(clinicalOrder);
        
        System.out.println("✅✅✅ ORDEN CLÍNICA CREADA EXITOSAMENTE");
        System.out.println("   - Tipo: " + clinicalOrder.getOrderType());
        System.out.println("   - Paciente: " + patient.getFullName());
        System.out.println("   - Doctor: " + doctor.getFullName());
        System.out.println("🔄 === FIN CREACIÓN ORDEN CLÍNICA ===\n");
    }
}
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
        System.out.println("CREANDO ORDEN CLÍNICA");
        
       
        User doctor = null;
        
        if (clinicalOrder.getDoctor().getUsername() != null) {
        
            doctor = userPort.findByUserName(clinicalOrder.getDoctor().getUsername());
        } else if (clinicalOrder.getDoctor().getId() > 0) {
            
            System.out.println("Buscando doctor por documento: " + clinicalOrder.getDoctor().getId());
       
            doctor = new User();
            doctor.setId(clinicalOrder.getDoctor().getId());
            doctor.setRole(Role.DOCTOR);
        }
        
        if (doctor == null) {
            throw new Exception("El doctor no existe en el sistema");
        }
        
        if (!doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("Las órdenes solo las pueden crear los Médicos");
        }
        
        System.out.println("Doctor validado");

       
        Patient patient = patientPort.findById(clinicalOrder.getPatient().getId());
        if (patient == null) {
            throw new Exception("Las órdenes se deben aplicar a pacientes ya registrados");
        }
        
        System.out.println("Paciente validado: " + patient.getFullName());

        clinicalOrder.setPatient(patient);
        clinicalOrder.setDoctor(doctor);
        
        clinicalOrderPort.save(clinicalOrder);
        
        System.out.println("Orden clínica guardada exitosamente");
        System.out.println(" FIN CREACIÓN DE ORDEN \n");
    }
}
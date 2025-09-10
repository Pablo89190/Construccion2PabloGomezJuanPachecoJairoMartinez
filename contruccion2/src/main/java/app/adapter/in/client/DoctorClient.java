package app.adapter.in.client;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.builder.ClinicalOrderBuilder;
import app.adapter.in.builder.ClinicalRecordBuilder;
import app.adapter.in.builder.RegistrationAttentionBuilder;
import app.application.usecases.DoctorUseCase;
import app.domain.model.Patient;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.DiagnosticOrder;
import app.domain.model.RegistrationAttention;

@Controller
public class DoctorClient {

    private static final String MENU = "Ingrese una opción:\n" +
            "1. Buscar historia clínica por paciente\n" +
            "2. Crear historia clínica\n" +
            "3. Crear orden clínica\n" +
            "4. Crear orden diagnóstica\n" +
            "5. Registrar atención médica\n" +
            "6. Cerrar sesión";

    @Autowired
    private DoctorUseCase doctorUseCase;
    @Autowired
    private PatientBuilder patientBuilder;
    @Autowired
    private ClinicalOrderBuilder clinicalOrderBuilder;
    @Autowired
    private ClinicalRecordBuilder clinicalRecordBuilder;
    @Autowired
    private RegistrationAttentionBuilder registrationAttentionBuilder;
    
    private static Scanner reader = new Scanner(System.in);

    public void session() {
        boolean session = true;
        while (session) {
            session = menu();
        }
    }

    private boolean menu() {
        try {
            System.out.println(MENU);
            String option = reader.nextLine();
            return options(option);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private boolean options(String option) throws Exception {
        switch (option) {
            case "1": {
                Patient patient = readPatientForSearch();
                List<ClinicalRecord> records = doctorUseCase.searchRecords(patient);
                System.out.println("Se encontraron " + records.size() + " registros clínicos");
                return true;
            }
            case "2": {
                ClinicalRecord clinicalRecord = readClinicalRecordData();
                doctorUseCase.createClinicalRecord(clinicalRecord);
                System.out.println("Historia clínica creada exitosamente");
                return true;
            }
            case "3": {
                ClinicalOrder clinicalOrder = readClinicalOrderData();
                doctorUseCase.createClinicalOrder(clinicalOrder);
                System.out.println("Orden clínica creada exitosamente");
                return true;
            }
            case "4": {
                DiagnosticOrder diagnosticOrder = readDiagnosticOrderData();
                doctorUseCase.createDiagnosticOrder(diagnosticOrder);
                System.out.println("Orden diagnóstica creada exitosamente");
                return true;
            }
            case "5": {
                RegistrationAttention attention = readRegistrationAttentionData();
                doctorUseCase.createClinicalRecord(clinicalRecordBuilder.buildBasic(attention.getPatient().getId() + ""));
                System.out.println("Atención médica registrada exitosamente");
                return true;
            }
            case "6": {
                System.out.println("Hasta luego \nCerrando sesión");
                return false;
            }
            default: {
                System.out.println("Ingrese una opción válida");
                return true;
            }
        }
    }

    private Patient readPatientForSearch() throws Exception {
        System.out.println("buscar historia Clínica");
        System.out.println("Ingrese el ID del paciente:");
        String patientId = reader.nextLine();
        

        Patient patient = new Patient();
        patient.setId(Long.parseLong(patientId));
        return patient;
    }

    private ClinicalRecord readClinicalRecordData() throws Exception {
        System.out.println("=== Crear Historia Clínica ===");
        System.out.println("Ingrese el ID del paciente:");
        String patientId = reader.nextLine();
        
        System.out.println("Ingrese su ID como doctor:");
        String doctorId = reader.nextLine();
        
        System.out.println("Ingrese el ID de la orden clínica:");
        String clinicalOrderId = reader.nextLine();
        
        return clinicalRecordBuilder.build(patientId, doctorId, clinicalOrderId);
    }

    private ClinicalOrder readClinicalOrderData() throws Exception {
        System.out.println("crear orden Clínica");
        System.out.println("Ingrese su ID como doctor:");
        String doctorId = reader.nextLine();
        
        System.out.println("Ingrese el ID del paciente:");
        String patientId = reader.nextLine();
        
        System.out.println("Ingrese el tipo de orden (MEDICINE, PROCEDURE, DIAGNOSTIC):");
        String orderType = reader.nextLine();
        
        return clinicalOrderBuilder.buildBasicOrder(doctorId, patientId, orderType);
    }

    private DiagnosticOrder readDiagnosticOrderData() throws Exception {
        System.out.println("crear orden Diagnóstica");
        System.out.println("Ingrese su ID como doctor:");
        String doctorId = reader.nextLine();
        
        System.out.println("Ingrese el ID del paciente:");
        String patientId = reader.nextLine();
        
        System.out.println("Ingrese el tipo de examen (XRAY, BLOOD_TEST, ULTRASOUND, COVID_TEST):");
        String examType = reader.nextLine();
        
        System.out.println("Ingrese la cantidad:");
        String quantity = reader.nextLine();
        
        System.out.println("Ingrese el costo:");
        String cost = reader.nextLine();
        
        return clinicalOrderBuilder.buildDiagnosticOrder(doctorId, patientId, examType, quantity, cost);
    }

    private RegistrationAttention readRegistrationAttentionData() throws Exception {
        System.out.println("registrar atención Médica");
        System.out.println("Ingrese el ID del paciente:");
        String patientId = reader.nextLine();
        
        System.out.println("Ingrese su ID como doctor:");
        String doctorId = reader.nextLine();
        
        System.out.println("Ingrese el motivo de la consulta:");
        String reason = reader.nextLine();
        
        System.out.println("Ingrese los síntomas:");
        String symptoms = reader.nextLine();
        
        System.out.println("Ingrese el diagnóstico:");
        String diagnosis = reader.nextLine();
        
        return registrationAttentionBuilder.build(patientId, doctorId, reason, symptoms, diagnosis);
    }
}

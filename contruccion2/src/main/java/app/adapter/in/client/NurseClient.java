package app.adapter.in.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.adapter.in.builder.VitalDataBuilder;
import app.adapter.in.builder.RegistrationAttentionBuilder;
import app.adapter.in.builder.ProcedureBuilder;
import app.application.usecases.NurseUseCase;
import app.domain.model.VitalData;
import app.domain.model.RegistrationAttention;
import app.domain.model.Procedure;

@Controller
public class NurseClient {

    private static final String MENU = "Ingrese una opción:\n" +
            "1. Registrar signos vitales\n" +
            "2. Registrar atención de enfermería\n" +
            "3. Crear procedimiento\n" +
            "4. Cerrar sesión";

    @Autowired
    private NurseUseCase nurseUseCase;
    @Autowired
    private VitalDataBuilder vitalDataBuilder;
    @Autowired
    private RegistrationAttentionBuilder registrationAttentionBuilder;
    @Autowired
    private ProcedureBuilder procedureBuilder;
    
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
                VitalData vitalData = readVitalDataInfo();
                nurseUseCase.registerVitalData(vitalData);
                System.out.println("Signos vitales registrados exitosamente");
                return true;
            }
            case "2": {
                RegistrationAttention attention = readAttentionInfo();
                VitalData vitalData = readVitalDataInfo();
                nurseUseCase.registerAttention(attention.getPatient().getId() + "", attention, vitalData);
                System.out.println("Atención de enfermería registrada exitosamente");
                return true;
            }
            case "3": {
                Procedure procedure = readProcedureInfo();
                nurseUseCase.createOrder(procedure);
                System.out.println("Procedimiento creado exitosamente");
                return true;
            }
            case "4": {
                System.out.println("Hasta luego \nCerrando sesión");
                return false;
            }
            default: {
                System.out.println("Ingrese una opción válida");
                return true;
            }
        }
    }

    private VitalData readVitalDataInfo() throws Exception {
        System.out.println("=== Registro de Signos Vitales ===");
        System.out.println("Ingrese la presión arterial (ej: 120/80):");
        String bloodPressure = reader.nextLine();
        
        System.out.println("Ingrese la temperatura (°C):");
        String temperature = reader.nextLine();
        
        System.out.println("Ingrese la frecuencia cardíaca (ppm):");
        String pulserate = reader.nextLine();
        
        System.out.println("Ingrese el nivel de oxígeno en sangre (%):");
        String bloodOxygenLevel = reader.nextLine();
        
        return vitalDataBuilder.build(bloodPressure, temperature, pulserate, bloodOxygenLevel);
    }

    private RegistrationAttention readAttentionInfo() throws Exception {
        System.out.println("=== Registro de Atención ===");
        System.out.println("Ingrese el ID del paciente:");
        String patientId = reader.nextLine();
        
        System.out.println("Ingrese el motivo de la consulta:");
        String reason = reader.nextLine();
        
        System.out.println("Ingrese los síntomas observados:");
        String symptoms = reader.nextLine();
        

        return registrationAttentionBuilder.buildNurseAttention(patientId, reason, symptoms);
    }

    private Procedure readProcedureInfo() throws Exception {
        System.out.println("=== Crear Procedimiento ===");
        System.out.println("Ingrese el nombre del procedimiento:");
        String name = reader.nextLine();
        
        System.out.println("Ingrese el número de veces:");
        String times = reader.nextLine();
        
        System.out.println("Ingrese la frecuencia:");
        String frequency = reader.nextLine();
        
        System.out.println("Ingrese el costo:");
        String cost = reader.nextLine();
        
        return procedureBuilder.buildGeneral(name, times, frequency, cost);
    }
}

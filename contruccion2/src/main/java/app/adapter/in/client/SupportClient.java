package app.adapter.in.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.adapter.in.builder.MedicineBuilder;
import app.adapter.in.builder.ProcedureBuilder;
import app.adapter.in.builder.ClinicalOrderBuilder;
import app.application.usecases.SupportUseCase;
import app.domain.model.Medicine;
import app.domain.model.Procedure;
import app.domain.model.DiagnosticOrder;

@Controller
public class SupportClient {

    private static final String MENU = "Ingrese una opción:\n" +
            "1. Crear medicamento\n" +
            "2. Actualizar medicamento\n" +
            "3. Eliminar medicamento\n" +
            "4. Crear procedimiento\n" +
            "5. Actualizar procedimiento\n" +
            "6. Eliminar procedimiento\n" +
            "7. Crear orden diagnóstica\n" +
            "8. Cerrar sesión";

    @Autowired
    private SupportUseCase supportUseCase;
    @Autowired
    private MedicineBuilder medicineBuilder;
    @Autowired
    private ProcedureBuilder procedureBuilder;
    @Autowired
    private ClinicalOrderBuilder clinicalOrderBuilder;
    
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
                Medicine medicine = readMedicineInfo();
                supportUseCase.createMedicine(medicine);
                System.out.println("Medicamento creado exitosamente");
                return true;
            }
            case "2": {
                Medicine medicine = readMedicineUpdateInfo();
                supportUseCase.updateMedicine(medicine);
                System.out.println("Medicamento actualizado exitosamente");
                return true;
            }
            case "3": {
                Medicine medicine = readMedicineForDelete();
                supportUseCase.deleteMedicine(medicine);
                System.out.println("Medicamento eliminado exitosamente");
                return true;
            }
            case "4": {
                Procedure procedure = readProcedureInfo();
                supportUseCase.createProcedure(procedure);
                System.out.println("Procedimiento creado exitosamente");
                return true;
            }
            case "5": {
                Procedure procedure = readProcedureUpdateInfo();
                supportUseCase.updateProcedure(procedure);
                System.out.println("Procedimiento actualizado exitosamente");
                return true;
            }
            case "6": {
                Procedure procedure = readProcedureForDelete();
                supportUseCase.deleteProcedure(procedure);
                System.out.println("Procedimiento eliminado exitosamente");
                return true;
            }
            case "7": {
                DiagnosticOrder order = readDiagnosticOrderInfo();
                supportUseCase.createDiagnosticOrder(order);
                System.out.println("Orden diagnóstica creada exitosamente");
                return true;
            }
            case "8": {
                System.out.println("Hasta luego \nCerrando sesión");
                return false;
            }
            default: {
                System.out.println("Ingrese una opción válida");
                return true;
            }
        }
    }

    private Medicine readMedicineInfo() throws Exception {
        System.out.println("=== Crear Medicamento ===");
        System.out.println("Ingrese el ID del medicamento:");
        String medicineId = reader.nextLine();
        
        System.out.println("Ingrese el nombre del medicamento:");
        String name = reader.nextLine();
        
        System.out.println("Ingrese la dosis:");
        String doce = reader.nextLine();
        
        System.out.println("Ingrese la duración del tratamiento:");
        String duration = reader.nextLine();
        
        System.out.println("Ingrese el costo:");
        String cost = reader.nextLine();
        
        return medicineBuilder.build(medicineId, name, doce, duration, cost);
    }

    private Medicine readMedicineUpdateInfo() throws Exception {
        System.out.println("=== Actualizar Medicamento ===");
        System.out.println("Ingrese el ID del medicamento a actualizar:");
        String medicineId = reader.nextLine();
        
        System.out.println("Ingrese el nuevo nombre (o presione Enter para mantener):");
        String name = reader.nextLine();
        
        System.out.println("Ingrese la nueva dosis (o presione Enter para mantener):");
        String doce = reader.nextLine();
        
        System.out.println("Ingrese la nueva duración (o presione Enter para mantener):");
        String duration = reader.nextLine();
        
        System.out.println("Ingrese el nuevo costo (o presione Enter para mantener):");
        String cost = reader.nextLine();
        
        return medicineBuilder.buildForUpdate(medicineId, name, doce, duration, cost);
    }

    private Medicine readMedicineForDelete() throws Exception {
        System.out.println("=== Eliminar Medicamento ===");
        System.out.println("Ingrese el ID del medicamento a eliminar:");
        String medicineId = reader.nextLine();
        
        return medicineBuilder.buildBasic("", ""); 
    }

    private Procedure readProcedureInfo() throws Exception {
        System.out.println("=== Crear Procedimiento ===");
        System.out.println("Ingrese el nombre del procedimiento:");
        String name = reader.nextLine();
        
        System.out.println("Ingrese el número de veces:");
        String times = reader.nextLine();
        
        System.out.println("Ingrese la frecuencia:");
        String frequency = reader.nextLine();
        
        System.out.println("¿Requiere especialista? (si/no):");
        String requiresSpecialist = reader.nextLine();
        
        String specialty = "";
        if (requiresSpecialist.toLowerCase().equals("si") || requiresSpecialist.toLowerCase().equals("sí")) {
            System.out.println("Ingrese la especialidad requerida (GENERAL_MEDICINE, PEDIATRICS, CARDIOLOGY, GYNECOLOGY, SURGERY):");
            specialty = reader.nextLine();
        }
        
        System.out.println("Ingrese el costo:");
        String cost = reader.nextLine();
        
        return procedureBuilder.build(name, times, frequency, requiresSpecialist, specialty, cost);
    }

    private Procedure readProcedureUpdateInfo() throws Exception {
        System.out.println("=== Actualizar Procedimiento ===");
        System.out.println("Ingrese el nombre del procedimiento a actualizar:");
        String name = reader.nextLine();
        
        System.out.println("Ingrese el nuevo número de veces (o presione Enter para mantener):");
        String times = reader.nextLine();
        
        System.out.println("Ingrese la nueva frecuencia (o presione Enter para mantener):");
        String frequency = reader.nextLine();
        
        System.out.println("¿Requiere especialista? (si/no o presione Enter para mantener):");
        String requiresSpecialist = reader.nextLine();
        
        String specialty = "";
        if (requiresSpecialist.toLowerCase().equals("si") || requiresSpecialist.toLowerCase().equals("sí")) {
            System.out.println("Ingrese la especialidad requerida:");
            specialty = reader.nextLine();
        }
        
        System.out.println("Ingrese el nuevo costo (o presione Enter para mantener):");
        String cost = reader.nextLine();
        
        return procedureBuilder.buildForUpdate(name, times, frequency, requiresSpecialist, specialty, cost);
    }

    private Procedure readProcedureForDelete() throws Exception {
        System.out.println("=== Eliminar Procedimiento ===");
        System.out.println("Ingrese el nombre del procedimiento a eliminar:");
        String name = reader.nextLine();
        
        return procedureBuilder.buildGeneral(name, "1", "N/A", "0"); 
    }

    private DiagnosticOrder readDiagnosticOrderInfo() throws Exception {
        System.out.println("=== Crear Orden Diagnóstica ===");
        System.out.println("Ingrese el ID del doctor:");
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
}

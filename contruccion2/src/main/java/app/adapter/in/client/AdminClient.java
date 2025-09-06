package app.adapter.in.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.adapter.in.builder.PatientBuilder;
import app.application.usecases.AdminUseCase;
import app.domain.model.User;


@Controller
public class AdminClient {

    private static final String MENU = "Ingrese una de las opciones \n 1. para crear paciente  \n 2. para salir";
    private static Scanner reader = new Scanner(System.in);
    @Autowired
    private AdminUseCase adminUseCase;
    @Autowired
    private PatientBuilder patientBuilder;

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
            switch (option) {
            
            
                case "1": {
                    // Nuevo caso para crear paciente
                    User patient = readPatientInfo();
                    adminUseCase.createPatient(patient);
                    return true;
                }
                
                
                case "2": {
                    System.out.println("hasta luego \n cerrando sesion");
                    return false;
                }
                default: {
                    System.out.println("ingrese una opcion valida");
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }



    
    private User readPatientInfo() throws Exception {
        
        
        System.out.println("Ingrese el género del paciente (masculino/femenino/otro):");
        String gender = reader.nextLine();

        System.out.println("Ingrese la dirección del paciente:");
        String address = reader.nextLine();

        System.out.println("Ingrese el número de teléfono del paciente (10 dígitos):");
        String phoneNumber = reader.nextLine();

        System.out.println("Ingrese el correo electrónico del paciente (si está disponible):");
        String email = reader.nextLine();
        
       
        System.out.println("--- Información de contacto de emergencia ---");
        System.out.println("Ingrese el nombre del contacto de emergencia:");
        String firstName = reader.nextLine();
        System.out.println("Ingrese la relación con el paciente:");
        String Relationship = reader.nextLine();
        System.out.println("Ingrese el número de teléfono de emergencia (10 dígitos):");
        String emergencyPhoneNumber = reader.nextLine();

        
        System.out.println("--- Información del seguro médico ---");
        System.out.println("Ingrese el nombre de la compañía de seguros:");
        String insuranceCompany = reader.nextLine();
        System.out.println("Ingrese el número de póliza:");
        String policyNumber = reader.nextLine();
        System.out.println("Ingrese el estado de la póliza (true para activa, false para inactiva):");
        boolean policyStatus = Boolean.parseBoolean(reader.nextLine());
        System.out.println("Ingrese la fecha de finalización de la póliza (dd/mm/yyyy):");
        String policyEndDate = reader.nextLine();
        
        return patientBuilder.build( gender, address, phoneNumber, email, firstName, Relationship, emergencyPhoneNumber, insuranceCompany,policyNumber,policyStatus,policyEndDate );

    }

}

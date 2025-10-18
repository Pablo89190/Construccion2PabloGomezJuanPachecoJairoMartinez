package app;

import app.adapter.in.client.HumanClient;
import app.adapter.in.client.AdminClient;
import app.adapter.in.client.DoctorClient;
import app.adapter.in.client.NurseClient;
import app.adapter.in.client.SupportClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Software2Application implements CommandLineRunner {
    
    private final HumanClient humanClient;
    private final AdminClient adminClient;
    private final DoctorClient doctorClient;
    private final NurseClient nurseClient;
    private final SupportClient supportClient;
    
    public Software2Application(HumanClient humanClient, 
                               AdminClient adminClient,
                               DoctorClient doctorClient,
                               NurseClient nurseClient,
                               SupportClient supportClient) {
        this.humanClient = humanClient;
        this.adminClient = adminClient;
        this.doctorClient = doctorClient;
        this.nurseClient = nurseClient;
        this.supportClient = supportClient;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Software2Application.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bienvenido al Sistema de Gestión Clínica \n");
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n Menú Principal");
            System.out.println("1. Recursos Humanos");
            System.out.println("2. Administrador");
            System.out.println("3. Médico");
            System.out.println("4. Enfermera");
            System.out.println("5. Soporte");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            String opcion = scanner.nextLine();
            
            switch (opcion) {
                case "1":
                    humanClient.session();
                    break;
                case "2":
                    adminClient.session();
                    break;
                case "3":
                    doctorClient.session();
                    break;
                case "4":
                    nurseClient.session();
                    break;
                case "5":
                    supportClient.session();
                    break;
                case "6":
                    System.out.println("Hasta luego");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        
        scanner.close();
     }
}
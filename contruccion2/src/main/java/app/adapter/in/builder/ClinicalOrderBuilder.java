package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;

import app.adapter.in.validators.UserValidator;
import app.adapter.in.validators.PatientValidator;
import app.domain.model.ClinicalOrder;
import app.domain.model.DiagnosticOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.ItemOrder;
import app.domain.model.emuns.OrderType;
import app.domain.model.emuns.DiagnosticExam;

@Component
public class ClinicalOrderBuilder {
    
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private PatientValidator patientValidator;

    public DiagnosticOrder buildDiagnosticOrder(String doctorId, String patientId, 
                                              String examType, String quantity, String cost) throws Exception {
        
        System.out.println("🔵 === Construyendo Orden Diagnóstica ===");
        System.out.println("  DoctorId: " + doctorId);
        System.out.println("  PatientId: " + patientId);
        System.out.println("  ExamType: " + examType);
        
        DiagnosticOrder order = new DiagnosticOrder();
        
        // NO establecer ID - JPA lo generará automáticamente
        
        // Validar y establecer doctor
        User doctor = new User();
        doctor.setId(userValidator.idValidator(doctorId));
        order.setDoctor(doctor);
        
        // Validar y establecer paciente
        Patient patient = new Patient();
        patient.setId(patientValidator.idValidator(patientId));
        order.setPatient(patient);
        
        // Validar y establecer examen
        if (examType == null || examType.trim().isEmpty()) {
            throw new Exception("El tipo de examen es requerido");
        }
        order.setExam(DiagnosticExam.valueOf(examType.toUpperCase()));
        
        // Validar y establecer cantidad
        order.setQuantity(userValidator.ageValidator(quantity)); 
        
        // Validar y establecer costo
        order.setCost(validateCost(cost));
        
        // Establecer valores por defecto
        order.setDate(LocalDate.now());
        order.setOrderType(OrderType.DIAGNOSTIC);
        order.setItems(new ArrayList<ItemOrder>());
        
        System.out.println("✅ Orden diagnóstica construida exitosamente");
        
        return order;
    }
    
    public ClinicalOrder buildBasicOrder(String doctorId, String patientId, String orderTypeStr) throws Exception {
        
        System.out.println("🔵 === Construyendo Orden Clínica Básica ===");
        System.out.println("  DoctorId: " + doctorId);
        System.out.println("  PatientId: " + patientId);
        System.out.println("  OrderType: " + orderTypeStr);
        
        // Validar que orderType no sea null
        if (orderTypeStr == null || orderTypeStr.trim().isEmpty()) {
            throw new Exception("El tipo de orden es requerido. Use: MEDICINE, PROCEDURE o DIAGNOSTIC");
        }
        
        ClinicalOrder order = new ClinicalOrder() {}; 
        
        // NO establecer ID - JPA lo generará automáticamente
        
        // Validar y establecer doctor
        User doctor = new User();
        doctor.setId(userValidator.idValidator(doctorId));
        order.setDoctor(doctor);
        
        // Validar y establecer paciente
        Patient patient = new Patient();
        patient.setId(patientValidator.idValidator(patientId));
        order.setPatient(patient);
   
        // Validar y establecer tipo de orden
        try {
            order.setOrderType(OrderType.valueOf(orderTypeStr.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new Exception("Tipo de orden inválido. Use: MEDICINE, PROCEDURE o DIAGNOSTIC");
        }
        
        // Establecer valores por defecto
        order.setDate(LocalDate.now());
        order.setItems(new ArrayList<ItemOrder>());
        
        System.out.println("✅ Orden clínica construida exitosamente");
        
        return order;
    }

    public ClinicalOrder buildOrderWithItems(String doctorId, String patientId, String orderTypeStr,
                                           String[] itemNumbers, String[] descriptions) throws Exception {
        
        ClinicalOrder order = buildBasicOrder(doctorId, patientId, orderTypeStr);
        
    
        if (itemNumbers != null && descriptions != null && itemNumbers.length == descriptions.length) {
            for (int i = 0; i < itemNumbers.length; i++) {
                ItemOrder item = new ItemOrder();
                item.setItemNumber(userValidator.nameValidator(itemNumbers[i]));
                item.setDescription(userValidator.nameValidator(descriptions[i]));
                order.getItems().add(item);
            }
        }
        
        return order;
    }
    
    private double validateCost(String cost) throws Exception {
        if (cost == null || cost.trim().isEmpty()) {
            throw new Exception("El costo no puede estar vacío");
        }
        try {
            double costValue = Double.parseDouble(cost);
            if (costValue < 0) {
                throw new Exception("El costo debe ser positivo");
            }
            return costValue;
        } catch (NumberFormatException e) {
            throw new Exception("El costo debe ser un valor numérico válido");
        }
    }
}
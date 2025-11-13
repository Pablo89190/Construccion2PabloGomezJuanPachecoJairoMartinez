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

    // ✅ MÉTODO 1: Órdenes Diagnósticas - CON COST
    public DiagnosticOrder buildDiagnosticOrder(String doctorId, String patientId, 
                                              String examType, String quantity, String cost) throws Exception {
        
        System.out.println(" Construyendo Orden Diagnóstica ");
        System.out.println("  DoctorId: " + doctorId);
        System.out.println("  PatientId: " + patientId);
        System.out.println("  ExamType: " + examType);
        
        DiagnosticOrder order = new DiagnosticOrder();
        
        User doctor = new User();
        doctor.setId(userValidator.idValidator(doctorId));
        order.setDoctor(doctor);
        
        Patient patient = new Patient();
        patient.setId(patientValidator.idValidator(patientId));
        order.setPatient(patient);
        
        if (examType == null || examType.trim().isEmpty()) {
            throw new Exception("El tipo de examen es requerido");
        }
        order.setExam(DiagnosticExam.valueOf(examType.toUpperCase()));
        
        order.setQuantity(userValidator.ageValidator(quantity)); 
        order.setCost(validateCost(cost));
        
        order.setDate(LocalDate.now());
        order.setOrderType(OrderType.DIAGNOSTIC);
        order.setItems(new ArrayList<ItemOrder>());
        
        System.out.println("✅ Orden diagnóstica construida exitosamente");
        
        return order;
    }
    
    // ✅ MÉTODO 2: Órdenes Normales (MEDICINE/PROCEDURE) - SIN COST
    public ClinicalOrder buildBasicOrder(String doctorId, String patientId, String orderTypeStr) throws Exception {
        
        System.out.println("Construyendo Orden Clínica Básica");
        System.out.println("  DoctorId: " + doctorId);
        System.out.println("  PatientId: " + patientId);
        System.out.println("  OrderType: " + orderTypeStr);

        if (orderTypeStr == null || orderTypeStr.trim().isEmpty()) {
            throw new Exception("El tipo de orden es requerido. Use: MEDICINE o PROCEDURE");
        }
        
        // Validar que NO sea DIAGNOSTIC - esas deben usar buildDiagnosticOrder()
        String upperType = orderTypeStr.toUpperCase();
        if (upperType.equals("DIAGNOSTIC")) {
            throw new Exception("Para órdenes DIAGNOSTIC use buildDiagnosticOrder() que incluye cost");
        }
        
        ClinicalOrder order = new ClinicalOrder() {}; 
        
        User doctor = new User();
        doctor.setId(userValidator.idValidator(doctorId));
        order.setDoctor(doctor);
        
        Patient patient = new Patient();
        patient.setId(patientValidator.idValidator(patientId));
        order.setPatient(patient);

        try {
            order.setOrderType(OrderType.valueOf(upperType));
        } catch (IllegalArgumentException e) {
            throw new Exception("Tipo de orden inválido. Use: MEDICINE o PROCEDURE");
        }
        
        order.setDate(LocalDate.now());
        order.setItems(new ArrayList<ItemOrder>());
        
        // ✅ NO establecer cost aquí - ClinicalOrder NO tiene este campo
        
        System.out.println("✅ Orden clínica construida exitosamente");
        
        return order;
    }

    // ✅ MÉTODO 3: Órdenes con Items - SIN COST
    public ClinicalOrder buildOrderWithItems(String doctorId, String patientId, String orderTypeStr,
                                           String[] itemNumbers, String[] descriptions) throws Exception {
        
        // Usar buildBasicOrder que valida correctamente
        ClinicalOrder order = buildBasicOrder(doctorId, patientId, orderTypeStr);
        
        // Agregar items
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
    
    // ✅ Validador de Cost - Solo para órdenes diagnósticas
    private double validateCost(String cost) throws Exception {
        if (cost == null || cost.trim().isEmpty()) {
            throw new Exception("El costo no puede estar vacío para órdenes diagnósticas");
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
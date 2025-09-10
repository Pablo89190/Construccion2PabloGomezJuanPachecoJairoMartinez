package app.adapter.in.builder;

import org.springframework.stereotype.Component;

import app.adapter.in.validators.SimpleValidators;
import app.domain.model.Procedure;
import app.domain.model.emuns.Specialty;

@Component
public class ProcedureBuilder extends SimpleValidators {

    public Procedure build(String name, String times, String frequency, String requiresSpecialist, 
                          String specialty, String cost) throws Exception {
        Procedure procedure = new Procedure();
        
        procedure.setName(stringValidator("nombre del procedimiento", name));
        procedure.setTimes(integerValidator("número de veces", times));
        procedure.setFrequency(stringValidator("frecuencia del procedimiento", frequency));
        procedure.setRequiresSpecialist(booleanValidator(requiresSpecialist));
        
        if (procedure.isRequiresSpecialist() && specialty != null && !specialty.trim().isEmpty()) {
            procedure.setSpecialty(Specialty.valueOf(specialty.toUpperCase()));
        }
        
        procedure.setCost(doubleValidator("costo del procedimiento", cost));
        
        return procedure;
    }
    
    public Procedure buildGeneral(String name, String times, String frequency, String cost) throws Exception {
        Procedure procedure = new Procedure();
        
        procedure.setName(stringValidator("nombre del procedimiento", name));
        procedure.setTimes(integerValidator("número de veces", times));
        procedure.setFrequency(stringValidator("frecuencia del procedimiento", frequency));
        procedure.setRequiresSpecialist(false);
        procedure.setCost(doubleValidator("costo del procedimiento", cost));
        
        return procedure;
    }
    
    public Procedure buildForUpdate(String name, String times, String frequency, 
                                   String requiresSpecialist, String specialty, String cost) throws Exception {
        Procedure procedure = new Procedure();
        
        procedure.setName(stringValidator("nombre del procedimiento", name));
        
        if (times != null && !times.trim().isEmpty()) {
            procedure.setTimes(integerValidator("número de veces", times));
        }
        
        if (frequency != null && !frequency.trim().isEmpty()) {
            procedure.setFrequency(stringValidator("frecuencia del procedimiento", frequency));
        }
        
        if (requiresSpecialist != null && !requiresSpecialist.trim().isEmpty()) {
            procedure.setRequiresSpecialist(booleanValidator(requiresSpecialist));
            
            if (procedure.isRequiresSpecialist() && specialty != null && !specialty.trim().isEmpty()) {
                procedure.setSpecialty(Specialty.valueOf(specialty.toUpperCase()));
            }
        }
        
        if (cost != null && !cost.trim().isEmpty()) {
            procedure.setCost(doubleValidator("costo del procedimiento", cost));
        }
        
        return procedure;
    }
    
    private boolean booleanValidator(String value) throws Exception {
        stringValidator("valor booleano", value);
        String normalizedValue = value.toLowerCase().trim();
        
        return normalizedValue.equals("true") || normalizedValue.equals("si") || 
               normalizedValue.equals("sí") || normalizedValue.equals("yes") || 
               normalizedValue.equals("1");
    }
}

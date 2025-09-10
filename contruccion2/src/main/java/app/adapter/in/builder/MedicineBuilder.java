package app.adapter.in.builder;

import org.springframework.stereotype.Component;

import app.adapter.in.validators.SimpleValidators;
import app.domain.model.Medicine;

@Component
public class MedicineBuilder extends SimpleValidators {

    public Medicine build(String medicineId, String name, String doce, String duration, String cost) throws Exception {
        Medicine medicine = new Medicine();
        
        medicine.setMedicineId(stringValidator("ID del medicamento", medicineId));
        medicine.setName(stringValidator("nombre del medicamento", name));
        medicine.setDoce(stringValidator("dosis del medicamento", doce));
        medicine.setDuration(stringValidator("duración del tratamiento", duration));
        medicine.setCost(doubleValidator("costo del medicamento", cost));
        
        return medicine;
    }
    
    public Medicine buildForUpdate(String medicineId, String name, String doce, String duration, String cost) throws Exception {
        Medicine medicine = new Medicine();
        
        medicine.setMedicineId(stringValidator("ID del medicamento", medicineId));
        
        if (name != null && !name.trim().isEmpty()) {
            medicine.setName(stringValidator("nombre del medicamento", name));
        }
        
        if (doce != null && !doce.trim().isEmpty()) {
            medicine.setDoce(stringValidator("dosis del medicamento", doce));
        }
        
        if (duration != null && !duration.trim().isEmpty()) {
            medicine.setDuration(stringValidator("duración del tratamiento", duration));
        }
        
        if (cost != null && !cost.trim().isEmpty()) {
            medicine.setCost(doubleValidator("costo del medicamento", cost));
        }
        
        return medicine;
    }
    
    public Medicine buildBasic(String name, String doce) throws Exception {
        Medicine medicine = new Medicine();
        
        medicine.setName(stringValidator("nombre del medicamento", name));
        medicine.setDoce(stringValidator("dosis del medicamento", doce));
        medicine.setMedicineId("MED-" + System.currentTimeMillis());
        
        return medicine;
    }
}

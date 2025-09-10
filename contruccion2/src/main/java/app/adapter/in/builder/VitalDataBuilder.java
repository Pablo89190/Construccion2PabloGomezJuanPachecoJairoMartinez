package app.adapter.in.builder;

import org.springframework.stereotype.Component;

import app.adapter.in.validators.SimpleValidators;
import app.domain.model.VitalData;

@Component
public class VitalDataBuilder extends SimpleValidators {

    public VitalData build(String bloodPressure, String temperature, String pulserate, String bloodOxygenLevel) throws Exception {
        VitalData vitalData = new VitalData();
        
        vitalData.setBloodPressure(stringValidator("presión arterial", bloodPressure));
        vitalData.setTemperature(stringValidator("temperatura", temperature));
        vitalData.setPulserate(stringValidator("frecuencia cardíaca", pulserate));
        vitalData.setBloodOxygenLevel(stringValidator("nivel de oxígeno en sangre", bloodOxygenLevel));
        
        return vitalData;
    }
}

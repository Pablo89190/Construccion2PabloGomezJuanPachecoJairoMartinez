package app.domain.services;

import app.domain.model.VitalData;
import app.domain.ports.VitalDataPort;

public class CreateVitalData {

    private VitalDataPort vitalDataPort;

    public CreateVitalData(VitalDataPort vitalDataPort) {
        this.vitalDataPort = vitalDataPort;
    }

    public void create(VitalData vitalData) throws Exception {
        if (vitalData == null) {
            throw new Exception("los datos vitales de un paciente no pueden ser nulos");
        }
        vitalDataPort.save(vitalData);
    }
}


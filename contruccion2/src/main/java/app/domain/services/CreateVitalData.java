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
<<<<<<< HEAD
}
=======
}
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275

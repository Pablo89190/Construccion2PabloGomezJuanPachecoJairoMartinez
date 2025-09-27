package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.VitalData;
import app.domain.ports.VitalDataPort;

@Service
public class CreateVitalData {

	@Autowired
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


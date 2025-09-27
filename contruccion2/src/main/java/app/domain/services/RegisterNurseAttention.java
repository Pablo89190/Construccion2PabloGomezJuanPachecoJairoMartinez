package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.RegistrationAttention;
import app.domain.model.VitalData;
import app.domain.ports.ClinicalRecordPort;

@Service
public class RegisterNurseAttention {
	@Autowired
    private ClinicalRecordPort clinicalRecordPort;

    public RegisterNurseAttention(ClinicalRecordPort clinicalRecordPort) {
        this.clinicalRecordPort = clinicalRecordPort;
    }

    public void registerAttention(String patientId, RegistrationAttention attention, VitalData vitalData) throws Exception {
        if (attention == null) {
            throw new Exception("La atención no puede ser nula");
        }


        attention.setVitalData(vitalData);
        clinicalRecordPort.addAttention(patientId, attention);
    }
}



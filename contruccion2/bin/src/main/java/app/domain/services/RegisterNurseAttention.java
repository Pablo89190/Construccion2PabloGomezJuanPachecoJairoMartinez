package app.domain.services;

import app.domain.model.RegistrationAttention;
import app.domain.model.VitalData;
import app.domain.ports.ClinicalRecordPort;

public class RegisterNurseAttention {
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

package app.domain.ports;

import app.domain.model.Insurance;

public interface InsurancePort {

    void saveInsurance(String patientId, Insurance insurance);
    Insurance findInsuranceByPatient(String patientId);
    void updateInsurance(String patientId, Insurance updatedInsurance);
    void deleteInsurance(String patientId);
}

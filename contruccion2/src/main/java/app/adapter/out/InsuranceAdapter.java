package app.adapter.out;

import org.springframework.stereotype.Service;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;

@Service
public class InsuranceAdapter implements InsurancePort {

    @Override
    public void saveInsurance(String patientId, Insurance insurance) {
        System.out.println("Guardando seguro médico para paciente: " + patientId);
    }

    @Override
    public Insurance findInsuranceByPatient(String patientId) {
        return new Insurance();
    }

    @Override
    public void updateInsurance(String patientId, Insurance updatedInsurance) {
        System.out.println("Actualizando seguro médico para paciente: " + patientId);
    }

    @Override
    public void deleteInsurance(String patientId) {
        System.out.println("Eliminando seguro médico para paciente: " + patientId);
    }
}
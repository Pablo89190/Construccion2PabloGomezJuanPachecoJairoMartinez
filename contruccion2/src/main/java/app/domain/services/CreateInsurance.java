package app.domain.services;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;

public class CreateInsurance {

    private final InsurancePort insurancePort;

    public CreateInsurance(InsurancePort insurancePort) {
        this.insurancePort = insurancePort;
    }

    public void registerInsurance(String patientId, String insuranceCompany, String policyNumber, String validity , String policyEndDate) {
        Insurance insurance = new Insurance();
        insurance.setCompany(insuranceCompany);
        insurance.setPolicyNumber(policyNumber);
        insurance.setValidity(validity);
        insurance.setPolicyEndDate(policyEndDate);

        insurancePort.saveInsurance(patientId, insurance);
    }
}


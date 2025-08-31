package app.domain.services;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;

public class CreateInsurance {

    private final InsurancePort insurancePort;

    public CreateInsurance(InsurancePort insurancePort) {
        this.insurancePort = insurancePort;
    }

    public void registerInsurance(String patientId, String company, String policyNumber, String validity) {
        Insurance insurance = new Insurance();
        insurance.setCompany(company);
        insurance.setPolicyNumber(policyNumber);
        insurance.setValidity(validity);

        insurancePort.saveInsurance(patientId, insurance);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275

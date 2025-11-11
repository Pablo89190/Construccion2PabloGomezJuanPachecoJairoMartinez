package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class PatientValidator extends SimpleValidators {

    public String firstNameValidator(String value) throws Exception {
        return stringValidator("Nombre del contacto de emergencia", value);
    }

    public String fullNameValidator(String value) throws Exception {
        return stringValidator("nombre del paciente", value);
    }
    
    public String emailValidator(String value) throws Exception {
        stringValidator("email del paciente", value);
        if (!value.contains("@")) {
            throw new Exception("El email debe contener @");
        }
        return value;
    }
    
    public String phoneValidator(String value) throws Exception {
        return stringValidator("teléfono del paciente", value);
    }
    
    public String emegercyPhoneNumber(String value) throws Exception {
        return stringValidator("teléfono de emergencia", value);
    }
    
    public int policyNumber(String value) throws Exception {
        return integerValidator("número de póliza", value);
    }
    
    public String policyEndDate(String value) throws Exception {
        return stringValidator("fecha de vencimiento de póliza", value);
    }
    
    public String addressValidator(String value) throws Exception {
        return stringValidator("dirección del paciente", value);
    }
    
    public long idValidator(String value) throws Exception {
        return longValidator("el documento de la persona", value);
    }
    
    public int ageValidator(String value) throws Exception {
        return integerValidator("edad de la persona", value);
    }
    
    public String genderValidator(String value) throws Exception {
        stringValidator("género de la persona", value);
        value = value.toUpperCase();
        if (!value.equals("MASCULINO") && !value.equals("FEMENINO")) {
            throw new Exception("El género debe ser MASCULINO o FEMENINO");
        }
        return value;
    }
    
    public String insuranceCompanyValidator(String value) throws Exception {
        return stringValidator("compañía de seguros", value);
    }
    
    public String relationShipValidator(String value) throws Exception {
        return stringValidator("parentesco del contacto de emergencia", value);
    }

    public String insuranceCompany(String insuranceCompany) throws Exception {
        return stringValidator("compañía de seguros", insuranceCompany);
    }
}
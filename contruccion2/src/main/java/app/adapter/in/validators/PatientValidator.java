package app.adapter.in.validators;

import org.springframework.stereotype.Component;

/**
 *
 * @author ESTUDIANTE
 */

@Component
public class PatientValidator extends SimpleValidators {

    public String firstNameValidator(String value) throws Exception {
        return stringValidator("Nombre del contacto de emergencia ", value);
    }

    
    public String fullNameValidator(String value) throws Exception {
		return stringValidator("nombre del paciente", value);
	}
    
    public String emailValidator(String value) throws Exception {
		return stringValidator("nombre del paciente", value);
	}
    
    public String emegercyPhoneNumber(String value) throws Exception {
		return stringValidator("nombre del paciente", value);
	}
	
    public int policyNumber(String value) throws Exception {
		return integerValidator("nombre del paciente", value);
	}
    public String policyEndDate(String value) throws Exception {
		return stringValidator("nombre del paciente", value);
	}
    
    public String address(String value) throws Exception {
		return stringValidator("nombre del paciente", value);
	}
	
	public long idValidator(String value) throws Exception {
		return longValidator("el documento de la persona", value);
	}
	
	public int ageValidator(String value) throws Exception {
		return integerValidator("edad de la persona", value);
	}
    
	public String genderValidator(String value) throws Exception {
		return stringValidator("edad de la persona", value);
	}
	
	public String insuranceCompanyValidator(String value) throws Exception {
		return stringValidator("edad de la persona", value);
	}
	
	public String relationShipValidator(String value) throws Exception {
		return stringValidator("edad de la persona", value);
	}


	public Object insuranceCompany(String insuranceCompany) {
		// TODO Auto-generated method stub
		return null;
	}


	public String addressValidator(String address) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
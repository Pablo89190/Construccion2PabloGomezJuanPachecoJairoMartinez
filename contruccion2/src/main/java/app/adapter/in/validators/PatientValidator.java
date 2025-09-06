package app.adapter.in.validators;

import org.springframework.stereotype.Component;

import app.domain.model.emuns.Gender;

/**
 *
 * @author ESTUDIANTE
 */

@Component
public class PatientValidator extends SimpleValidators {

    public String nameValidator(String value) throws Exception {
        return stringValidator("Nombre del paciente ", value);
    }

    
    public Gender spicesValidator(String value) throws Exception {
        stringValidator("Genero del paciente ", value);
        return Gender.valueOf(value);
    }
    
    public String breedValidator(String value) throws Exception {
        return stringValidator("Nombre de la mascota ", value);
    }
    public double weigthValidator(String value) throws Exception{
        return doubleValidator("el peso de la mascota", value);
    }
    public int ageValidator(String value) throws Exception{
        return integerValidator("Edad del paciente", value);
    }
    
    public long idValidator(String value) throws Exception{
        return longValidator("Documento del paciente", value);
    }
    

}
package app.domain.ports;

import java.util.List;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;

public interface ClinicalOrderPort {
	
	public ClinicalOrder findById(ClinicalOrder clinicalOrder)throws Exception;
	public List<ClinicalOrder> findByPatient(Patient patient)throws Exception;
	public void save (ClinicalOrder clinicalOrder) throws Exception;
}

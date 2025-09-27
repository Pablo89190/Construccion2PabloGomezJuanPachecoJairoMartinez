package app.application.usecases;

import java.util.List;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.DiagnosticOrder;
import app.domain.model.Patient;
import app.domain.model.RegistrationAttention;
import app.domain.services.CreateClinicalOrder;
import app.domain.services.CreateClinicalRecord;
import app.domain.services.CreateDiagnosticOrder;
import app.domain.services.SearchClinicalRecordByPatient;
import app.domain.services.UpdateMedicalRegistry;

public class DoctorUseCase {
    private CreateClinicalOrder createClinicalOrder;
    private CreateClinicalRecord createClinicalRecord;
    private CreateDiagnosticOrder createDiagnosticOrder;
    private SearchClinicalRecordByPatient searchClinicalRecordByPatient;
    private UpdateMedicalRegistry updateMedicalRegistry;

    public DoctorUseCase(CreateClinicalOrder createClinicalOrder,
                         CreateClinicalRecord createClinicalRecord,
                         CreateDiagnosticOrder createDiagnosticOrder,
                         SearchClinicalRecordByPatient searchClinicalRecordByPatient,
                         UpdateMedicalRegistry updateMedicalRegistry) {
        this.createClinicalOrder = createClinicalOrder;
        this.createClinicalRecord = createClinicalRecord;
        this.createDiagnosticOrder = createDiagnosticOrder;
        this.searchClinicalRecordByPatient = searchClinicalRecordByPatient;
        this.updateMedicalRegistry = updateMedicalRegistry;
    }

    public void createClinicalOrder(ClinicalOrder order) throws Exception {
        createClinicalOrder.create(order);
    }

    public void createClinicalRecord(ClinicalRecord record) throws Exception {
        createClinicalRecord.create(record);
    }

    public void createDiagnosticOrder(DiagnosticOrder order) throws Exception {
        createDiagnosticOrder.create(order);
    }
   
    public List<ClinicalRecord> searchRecords(Patient patient) throws Exception {
        return searchClinicalRecordByPatient.search(patient.getId());
    }

    public void updateClinicalRecord(ClinicalRecord clinicalRecord) throws Exception {
        updateMedicalRegistry.updateRecord(clinicalRecord);
    }

    public void addAttentionToRecord(String patientId, String date, RegistrationAttention attention) throws Exception {
        updateMedicalRegistry.addAttentionToRecord(patientId, date, attention);
    }
}

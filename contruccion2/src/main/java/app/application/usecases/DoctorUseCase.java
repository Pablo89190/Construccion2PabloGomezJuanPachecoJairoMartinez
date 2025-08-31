package app.application.usecases;

import java.util.List;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.DiagnosticOrder;
import app.domain.model.Patient;
import app.domain.services.CreateClinicalOrder;
import app.domain.services.CreateClinicalRecord;
import app.domain.services.CreateDiagnosticOrder;
import app.domain.services.SearchClinicalRecordByPatient;

public class DoctorUseCase {
    private CreateClinicalOrder createClinicalOrder;
    private CreateClinicalRecord createClinicalRecord;
    private CreateDiagnosticOrder createDiagnosticOrder;
    private SearchClinicalRecordByPatient searchClinicalRecordByPatient;

    public DoctorUseCase(CreateClinicalOrder createClinicalOrder,
                         CreateClinicalRecord createClinicalRecord,
                         CreateDiagnosticOrder createDiagnosticOrder,
                         SearchClinicalRecordByPatient searchClinicalRecordByPatient) {
        this.createClinicalOrder = createClinicalOrder;
        this.createClinicalRecord = createClinicalRecord;
        this.createDiagnosticOrder = createDiagnosticOrder;
        this.searchClinicalRecordByPatient = searchClinicalRecordByPatient;
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
}

<<<<<<< HEAD



=======
    public DoctorUseCase(CreateClinicalOrder createClinicalOrder,
                         CreateClinicalRecord createClinicalRecord,
                         CreateDiagnosticOrder createDiagnosticOrder,
                         SearchClinicalRecordByPatient searchClinicalRecordByPatient) {
        this.createClinicalOrder = createClinicalOrder;
        this.createClinicalRecord = createClinicalRecord;
        this.createDiagnosticOrder = createDiagnosticOrder;
        this.searchClinicalRecordByPatient = searchClinicalRecordByPatient;
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
}
>>>>>>> d98169972ccf3fa424acb23690ca2ab08e9e2219


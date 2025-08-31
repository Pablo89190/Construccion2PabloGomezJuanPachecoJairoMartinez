package app.application.usecases;

import app.domain.model.Medicine;
import app.domain.model.Procedure;
import app.domain.model.DiagnosticOrder;
import app.domain.services.CreateMedicine;
import app.domain.services.CreateProcedure;
import app.domain.services.CreateDiagnosticOrder;

public class SupportUseCase {
    private CreateMedicine createMedicine;
    private CreateProcedure createProcedure;
    private CreateDiagnosticOrder createDiagnosticOrder;

    public SupportUseCase(CreateMedicine createMedicine, CreateProcedure createProcedure, CreateDiagnosticOrder createDiagnosticOrder) {
        this.createMedicine = createMedicine;
        this.createProcedure = createProcedure;
        this.createDiagnosticOrder = createDiagnosticOrder;
    }


    public void createMedicine(Medicine medicine) throws Exception {
        createMedicine.create(medicine);
    }

    public void updateMedicine(Medicine medicine) throws Exception {
        createMedicine.update(medicine);
    }

    public void deleteMedicine(Medicine medicine) throws Exception {
        createMedicine.delete(medicine);
    }

   
    public void createProcedure(Procedure procedure) throws Exception {
        createProcedure.create(procedure);
    }

    public void updateProcedure(Procedure procedure) throws Exception {
        createProcedure.update(procedure);
    }

    public void deleteProcedure(Procedure procedure) throws Exception {
        createProcedure.delete(procedure);
    }

    public void createDiagnosticOrder(DiagnosticOrder order) throws Exception {
        createDiagnosticOrder.create(order);
    }
}

package app.application.usecases;

import app.domain.model.Medicine;
import app.domain.model.Procedure;
import app.domain.services.CreateMedicine;
import app.domain.services.CreateProcedure;

public class SupportUseCase {

    private CreateMedicine createMedicine;
    private CreateProcedure createProcedure;

    public SupportUseCase(CreateMedicine createMedicine, CreateProcedure createProcedure) {
        this.createMedicine = createMedicine;
        this.createProcedure = createProcedure;
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
}

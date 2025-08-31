package app.domain.services;

import app.domain.model.Procedure;
import app.domain.ports.ProcedurePort;

public class CreateProcedure {

    private ProcedurePort procedurePort;

    public CreateProcedure(ProcedurePort procedurePort) {
        this.procedurePort = procedurePort;
    }

    public void create(Procedure procedure) throws Exception {
        if (procedurePort.findByName(procedure.getName()) != null) {
            throw new Exception("El procedimiento ya existe en el inventario");
        }
        procedurePort.save(procedure);
    }

    public void update(Procedure procedure) throws Exception {
        if (procedurePort.findById(procedure.getName()) == null) {
            throw new Exception("No existe un procedimiento con este nombre");
        }
        procedurePort.update(procedure);
    }

    public void delete(Procedure procedure) throws Exception {
        if (procedurePort.findById(procedure.getName()) == null) {
            throw new Exception("No existe un procedimiento con este nombre");
        }
        procedurePort.delete(procedure);
    }
}
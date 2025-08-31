package app.domain.ports;

import app.domain.model.Procedure;

public interface ProcedurePort {
    
    Procedure findById(String id);
    
    Procedure findByName(String name);
    
    void save(Procedure procedure);
    
    void update(Procedure procedure);
    
    void delete(Procedure procedure);
}

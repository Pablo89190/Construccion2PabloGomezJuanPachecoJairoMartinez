package app.domain.ports;

import app.domain.model.DiagnosticOrder;

public interface DiagnosticOrderPort {
    void save(DiagnosticOrder order);
    DiagnosticOrder findById(String id);
}

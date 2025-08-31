package app.domain.ports;

import app.domain.model.VitalData;

public interface VitalDataPort {
    VitalData save(VitalData vitalData);
    VitalData findById(String id);
}
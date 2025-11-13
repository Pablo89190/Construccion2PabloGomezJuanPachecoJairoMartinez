package app.infrastructure.persistence.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DIAGNOSTIC_ORDER")
public class DiagnosticOrderEntity extends ClinicalOrderEntity {

  
    public DiagnosticOrderEntity() {
        super();
    }


}
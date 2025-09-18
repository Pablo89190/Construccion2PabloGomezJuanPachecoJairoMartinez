package app.infrastructure.persistence.mapper;

import app.domain.model.InvoiceDetail;
import app.infrastructure.persistence.entities.InvoiceDetailEntity;

public class InvoiceDetailMapper {

    public static InvoiceDetailEntity toEntity(InvoiceDetail domain) {
        if (domain == null) return null;

        InvoiceDetailEntity entity = new InvoiceDetailEntity();
        entity.setConcept(domain.getConcept());
        entity.setQuantity(domain.getQuantity());
        entity.setUnitCost(domain.getUnitCost());
        entity.setSubtotal(domain.getSubtotal());

        return entity;
    }

    public static InvoiceDetail toDomain(InvoiceDetailEntity entity) {
        if (entity == null) return null;

        InvoiceDetail domain = new InvoiceDetail();
        domain.setConcept(entity.getConcept());
        domain.setQuantity(entity.getQuantity());
        domain.setUnitCost(entity.getUnitCost());
        domain.setSubtotal(entity.getSubtotal());

        return domain;
    }
}
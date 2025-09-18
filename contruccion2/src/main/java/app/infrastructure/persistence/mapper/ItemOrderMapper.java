package app.infrastructure.persistence.mapper;

import app.domain.model.ItemOrder;
import app.infrastructure.persistence.entities.ItemOrderEntity;

public class ItemOrderMapper {

    // Dominio → Entidad
    public static ItemOrderEntity toEntity(ItemOrder domain) {
        if (domain == null) return null;

        ItemOrderEntity entity = new ItemOrderEntity();
        entity.setItemNumber(domain.getItemNumber());
        entity.setDescription(domain.getDescription());

        return entity;
    }

    // Entidad → Dominio
    public static ItemOrder toDomain(ItemOrderEntity entity) {
        if (entity == null) return null;

        ItemOrder domain = new ItemOrder();
        domain.setItemNumber(entity.getItemNumber());
        domain.setDescription(entity.getDescription());

        return domain;
    }
}
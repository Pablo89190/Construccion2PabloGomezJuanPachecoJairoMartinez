package app.infrastructure.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import app.domain.model.ClinicalOrder;
import app.domain.model.ItemOrder;
import app.domain.model.emuns.OrderType;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.entities.ItemOrderEntity;

public class ClinicalOrderMapper {

    // Dominio → Entidad
    public static ClinicalOrderEntity toEntity(ClinicalOrder domain) {
        if (domain == null) return null;

        ClinicalOrderEntity entity = new ClinicalOrderEntity();
        entity.setId(domain.getId());
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
        entity.setDate(domain.getDate());
        entity.setOrderType(domain.getOrderType().name());

  
        if (domain.getItems() != null && !domain.getItems().isEmpty()) {
            List<ItemOrderEntity> itemEntities = new ArrayList<>();
            for (ItemOrder item : domain.getItems()) {
                ItemOrderEntity itemEntity = ItemOrderMapper.toEntity(item);
                itemEntity.setClinicalOrder(entity);
                itemEntities.add(itemEntity);
            }
            entity.setItems(itemEntities);
        }

        return entity;
    }

    // Entidad → Dominio
    public static ClinicalOrder toDomain(ClinicalOrderEntity entity) {
        if (entity == null) return null;

  
        ClinicalOrder domain = new ClinicalOrder() {};
        
        domain.setId(entity.getId());
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setDate(entity.getDate());
        domain.setOrderType(OrderType.valueOf(entity.getOrderType()));


        if (entity.getItems() != null && !entity.getItems().isEmpty()) {
            List<ItemOrder> items = new ArrayList<>();
            for (ItemOrderEntity itemEntity : entity.getItems()) {
                items.add(ItemOrderMapper.toDomain(itemEntity));
            }
            domain.setItems(items);
        } else {
            domain.setItems(new ArrayList<>());
        }

        return domain;
    }
}

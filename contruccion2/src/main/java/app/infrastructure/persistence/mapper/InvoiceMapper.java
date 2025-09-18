package app.infrastructure.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import app.domain.model.Invoice;
import app.domain.model.InvoiceDetail;
import app.infrastructure.persistence.entities.InvoiceEntity;
import app.infrastructure.persistence.entities.InvoiceDetailEntity;

public class InvoiceMapper {

    // Dominio → Entidad
    public static InvoiceEntity toEntity(Invoice domain) {
        if (domain == null) return null;

        InvoiceEntity entity = new InvoiceEntity();
        entity.setInvoiceId(domain.getInvoiceId());
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
        entity.setTotal(domain.getTotal());
        entity.setMedicine(domain.isMedicineId());

        if (domain.getOrder() != null) {
            entity.setClinicalOrder(ClinicalOrderMapper.toEntity(domain.getOrder()));
        }

        // Mapear detalles
        if (domain.getDetails() != null && !domain.getDetails().isEmpty()) {
            List<InvoiceDetailEntity> detailEntities = new ArrayList<>();
            for (InvoiceDetail detail : domain.getDetails()) {
                InvoiceDetailEntity detailEntity = InvoiceDetailMapper.toEntity(detail);
                detailEntity.setInvoice(entity);
                detailEntities.add(detailEntity);
            }
            entity.setDetails(detailEntities);
        }

        return entity;
    }

    // Entidad → Dominio
    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) return null;

        Invoice domain = new Invoice();
        domain.setInvoiceId(entity.getInvoiceId());
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setTotal(entity.getTotal());

        if (entity.getClinicalOrder() != null) {
            domain.setOrder(ClinicalOrderMapper.toDomain(entity.getClinicalOrder()));
        }

        
        if (entity.getDetails() != null && !entity.getDetails().isEmpty()) {
            List<InvoiceDetail> details = new ArrayList<>();
            for (InvoiceDetailEntity detailEntity : entity.getDetails()) {
                details.add(InvoiceDetailMapper.toDomain(detailEntity));
            }
            domain.setDetails(details);
        }

        return domain;
    }
}
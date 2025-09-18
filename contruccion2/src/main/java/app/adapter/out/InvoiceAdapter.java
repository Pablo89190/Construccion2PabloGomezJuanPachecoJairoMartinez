package app.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Invoice;
import app.domain.ports.InvoicePort;
import app.infrastructure.persistence.entities.InvoiceEntity;
import app.infrastructure.persistence.mapper.InvoiceMapper;
import app.infrastructure.persistence.repository.InvoiceRepository;

@Service
public class InvoiceAdapter implements InvoicePort {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void save(Invoice invoice) throws Exception {
        try {
            InvoiceEntity entity = InvoiceMapper.toEntity(invoice);
            invoiceRepository.save(entity);
            System.out.println("Factura guardada exitosamente con ID: " + invoice.getInvoiceId());
        } catch (Exception e) {
            throw new Exception("Error al guardar la factura: " + e.getMessage());
        }
    }
}
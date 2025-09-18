package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.InvoiceEntity;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, String> {
    
    InvoiceEntity findByInvoiceId(String invoiceId);
    
    @Query("SELECT i FROM InvoiceEntity i WHERE i.patient.id = :patientId")
    List<InvoiceEntity> findByPatientId(@Param("patientId") long patientId);
    
    @Query("SELECT i FROM InvoiceEntity i WHERE i.doctor.id = :doctorId")
    List<InvoiceEntity> findByDoctorId(@Param("doctorId") long doctorId);
    
    @Query("SELECT i FROM InvoiceEntity i WHERE i.isMedicine = true")
    List<InvoiceEntity> findMedicineInvoices();
}
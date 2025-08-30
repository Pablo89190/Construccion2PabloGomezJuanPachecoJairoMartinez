package app.domain.services;

import app.domain.model.Medicine;
import app.domain.ports.MedicinePort;

public class CreateMedicine {

    private MedicinePort medicinePort;

    public CreateMedicine(MedicinePort medicinePort) {
        this.medicinePort = medicinePort;
    }

    public void create(Medicine medicine) throws Exception {
        if (medicinePort.findByName(medicine.getName()) != null) {
            throw new Exception("El medicamento ya existe en el inventario con ese nombre");
        }
        if (medicinePort.findByMedicineId(medicine.getMedicineId()) != null) {
            throw new Exception("El medicamento ya existe con este ID");
        }
        medicinePort.save(medicine);
    }

    public void update(Medicine medicine) throws Exception {
        if (medicinePort.findByMedicineId(medicine.getMedicineId()) == null) {
            throw new Exception("No existe un medicamento con este ID");
        }
        medicinePort.update(medicine);
    }

    public void delete(Medicine medicine) throws Exception {
        if (medicinePort.findByMedicineId(medicine.getMedicineId()) == null) {
            throw new Exception("No existe un medicamento con este ID");
        }
        medicinePort.delete(medicine);
    }
}

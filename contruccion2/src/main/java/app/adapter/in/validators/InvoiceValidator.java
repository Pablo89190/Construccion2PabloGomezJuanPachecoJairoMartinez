package app.adapter.in.validators;

public class InvoiceValidator extends SimpleValidators {
	
	public String productNameValidator(String value) throws Exception {
		return stringValidator("nombre del producto", value);
	}
	
	public long patientIdValidator(String value) throws Exception {
		return longValidator("Id del paciente", value);
	}
	
	public boolean isMedicineValidator(String value) throws Exception {
		stringValidator("venta de medicina", value);
		return value.equals("si");
	}
	
	public long orderIdValidator(String value) throws Exception {
		return longValidator("id de la orden", value);
	}
	
	public double amountValidator(String value) throws Exception{
		return doubleValidator("precio de la factura", value);
	}

}
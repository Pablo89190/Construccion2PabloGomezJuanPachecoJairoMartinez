package app.adapter.in.client;

import java.util.Scanner;

import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.builder.UserBuilder;
import app.application.usecases.DoctorUseCase;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.services.SearchClinicalRecordByPatient;

public class DoctorClient {

	private static final String MENU = "Ingrese una opcion \n" + "1. Buscar historia clinica.\n"
			+ "2. para crear paciente.\n" + "3. para cerrar sesion.";

	private DoctorUseCase doctorUseCase;
	private UserBuilder userBuilder;
	private static Scanner reader = new Scanner(System.in);

	public void session() {
		boolean session = true;
		while (session) {
			session = menu();
		}
	}

	private boolean menu() {
		try {
			System.out.println(MENU);
			String option = reader.nextLine();
			return options(option);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}

	private boolean options(String option) throws Exception {
		switch (option) {
		case "1": {
			ClinicalRecord clinicalRecord = searchClinicalRecordByPatient();
			doctorUseCase.searchClinicalRecordByPatient(clinicalRecord);
			return true;
		}
		case "2": {
			// Pet pet = readPetData();
			// veterinarianUseCase.CreatePet(pet);
			return true;
		}
		case "3": {

			return true;
		}
		
		}
		return false;
	}

	private ClinicalRecord readOrderData() throws Exception {
		System.out.println("ingrese la cedula del veterinario que la genera");
		String veterinarian = reader.nextLine();
		System.out.println("ingrese el id de la mascota");
		String id = reader.nextLine();
		System.out.println("ingrese el nombre de la medicina");
		String medicine = reader.nextLine();
		System.out.println("ingrese la dosis");
		String doce = reader.nextLine();
		return clinicalRecordBuilder.builder(veterinarian, id, medicine, doce);

	}

	private Patient readPatientData() throws Exception {
		System.out.println("ingrese la cedula del dueño");
		String document = reader.nextLine();
		System.out.println("ingrese el nombre de la mascota");
		String name = reader.nextLine();
		System.out.println("ingrese la edad de la mascota");
		String age = reader.nextLine();
		System.out.println("ingrese el peso");
		String weigth = reader.nextLine();
		System.out.println("ingrese la especie");
		String spices = reader.nextLine();
		System.out.println("ingrese las caracteristicas");
		String features = reader.nextLine();
		System.out.println("ingrese la raza");
		String breed = reader.nextLine();

		return patientBuilder.builder(document, name, age, weigth, spices, features, breed);
	}

	private User readOwnerData() throws Exception {
		System.out.println("ingrese el nombre del dueño");
		String name = reader.nextLine();
		System.out.println("ingrese la cedula del dueño");
		String document = reader.nextLine();
		System.out.println("ingrese la edad del dueño");
		String age = reader.nextLine();
		return userBuilder.build(name, document, age, "N/A", "N/A");
	}
}
package app.adapter.in.client;

import java.util.Scanner;

import app.adapter.in.builder.UserBuilder;
import app.application.usecases.DoctorUseCase;
import app.domain.model.ClinicalRecord;
import app.domain.model.User;

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
			ClinicalRecod clinicalRecord = searchClinicalRecordByPatientData();
			doctorUseCase.CreateClinicalRecord(clinicalRecord);
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
	}

	private ClinicalRecord readClinicalRecordData() throws Exception {
		System.out.println("ingrese el nombre del dueño");
		String name = reader.nextLine();
		System.out.println("ingrese la cedula del dueño");
		String document = reader.nextLine();
		System.out.println("ingrese la edad del dueño");
		String age = reader.nextLine();
		return userBuilder.build(name, document, age, "N/A", "N/A");
	}
}
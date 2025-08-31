package app.adapter.in.client;

import java.util.Scanner;

import app.adapter.in.builder.UserBuilder;
import app.application.usecases.HumanUseCase;
import app.domain.model.User;

public class HumanClient {

	private static final String MENU = "Ingrese una de las opciones \n 1. Para crear Administrador \n 2. Para crear Soporte de informacion \n 3. Para crear Doctor \n 4. Para crear enfermera \n 5. salir ";
	private static Scanner reader = new Scanner(System.in);
	private HumanUseCase humanUseCase;
	private UserBuilder userBuilder;

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
			switch (option) {
			case "1": {
				User user = readInfoFromUser();
				humanUseCase.createAdmin(user);
				return true;
			}
			case "2": {
				User user = readInfoFromUser();
				humanUseCase.createSupport(user);
				return true;
			}
			case "3": {
				User user = readInfoFromUser();
				humanUseCase.createDoctor(user);
				return true;
			}
			case "4": {
				User user = readInfoFromUser();
				humanUseCase.createNurse(user);
				return true;
			}
			case "5": {
				System.out.println("hasta luego \n cerrando sesion");
				return false;
			}
			default: {
				System.out.println("ingrese una opcion valida");
				return true;
			}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
	
	private User readInfoFromUser() throws Exception{
		System.out.println("ingrese el nombre de la persona");
		String name = reader.nextLine();
		System.out.println("ingrese la cedula de la persona");
		String id = reader.nextLine();
		System.out.println("ingrese el nombre de de usuario");
		String userName = reader.nextLine();
		System.out.println("ingrese la contraseña");
		String password = reader.nextLine();
		System.out.println("ingrese la edad de la persona");
		String age = reader.nextLine();
		return userBuilder.build(name, id, age, userName, password);
		
	}

}
package railticket.registration;

import railticket.registration.RegistrationImplementation;

public class TestgetUserPassword {

	public static void main(String[] args) throws Exception {
		RegistrationImplementation obj = new RegistrationImplementation();
		String password=obj.getUserPassword("mohamed@gmail.com");
		System.out.println(password);

	}

}

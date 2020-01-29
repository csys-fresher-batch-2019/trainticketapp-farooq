package railticket.registration;

import railticket.Registration.RegistrationImplementation;

public class TestgetUserPassword {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RegistrationImplementation obj = new RegistrationImplementation();
		String password=obj.getUserPassword1("mohamed@gmail.com");
		System.out.println(password);

	}

}

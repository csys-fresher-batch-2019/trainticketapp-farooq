package railticket.registration;


import railticket.registration.RegistrationImplementation;

public class TestchangePassword {

	public static void main(String[] args)throws Exception {
		RegistrationImplementation obj = new RegistrationImplementation();
		obj.changePassword("farooq@gmail.com","pass112");
System.out.println("SUCCESSFULLY CHANGED");
	}

}

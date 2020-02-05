package railticket.registration;


import railticket.Registration.RegistrationImplementation;

public class TestchangePassword {

	public static void main(String[] args)throws Exception {
		RegistrationImplementation obj = new RegistrationImplementation();
		obj.changePassword("ameer@gmail.com","pass112");
System.out.println("SUCCESSFULLY CHANGED");
	}

}

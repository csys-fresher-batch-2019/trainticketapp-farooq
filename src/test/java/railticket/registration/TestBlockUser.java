package railticket.registration;

import railticket.registration.RegistrationImplementation;

public class TestBlockUser {

	public static void main(String[] args) {
RegistrationImplementation obj = new RegistrationImplementation();
try {
	obj.blockUser(1031, 1);
	System.out.println("DONE");
} catch (Exception e) {
	e.printStackTrace();
}
		
	}

}

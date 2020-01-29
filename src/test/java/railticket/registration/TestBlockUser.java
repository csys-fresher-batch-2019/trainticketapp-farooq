package railticket.registration;

import railticket.Registration.RegistrationImplementation;

public class TestBlockUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RegistrationImplementation obj = new RegistrationImplementation();
try {
	obj.blockUser(1020, 0);
	System.out.println("DONE");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
	}

}

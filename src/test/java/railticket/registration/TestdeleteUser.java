package railticket.registration;

import railticket.Registration.RegistrationImplementation;

public class TestdeleteUser {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RegistrationImplementation obj = new RegistrationImplementation();
obj.deleteUser("ameer@gmail.com");//AS SEQUENCE DELETED WRONG PERSON DETAILS WILL BE DELETED.
System.out.println("SUCCESFULLY DELETED");
	}

}

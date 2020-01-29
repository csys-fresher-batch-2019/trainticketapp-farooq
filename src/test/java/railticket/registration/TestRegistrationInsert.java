package railticket.registration;

import java.time.LocalDate;

import railticket.Registration.RegistrationImplementation;

public class TestRegistrationInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RegistrationImplementation obj = new RegistrationImplementation();

		try {
			LocalDate dob = LocalDate.parse("2020-02-19");
			
			obj.registrationInsert("farooq", "pass11", "matd@gmail.com", 8778677667l, "M",dob,"madurai");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

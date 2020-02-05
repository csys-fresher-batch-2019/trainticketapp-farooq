package railticket.registration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import railticket.Registration.Register;
import railticket.Registration.RegistrationImplementation;

public class TestgetUserDetails {

	public static void main(String[] args) throws Exception {
		RegistrationImplementation obj = new RegistrationImplementation();

		List<Register> reg = obj.getUserDetails(1001);

		
		for (Register r : reg) {
			String line = "username=" + r.getUsername() + "," + "user-id=" + r.getUserid() + "," + "email-id=" + r.getEmailid() + ","
					+ "gender=" + r.getGender() + "," + "password=" + r.getPassword() + "," + "cityname=" + r.getCityname() + ",";
		
		Path path = Paths.get("userdetails.txt");
		Files.write(path, line.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
		}
	}

}

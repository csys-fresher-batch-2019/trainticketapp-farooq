package railticket.registration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import railticket.Registration.Register;
import railticket.Registration.RegistrationImplementation;

public class TestLoadFile {

	public static void main(String[] args) throws Exception {

		Path path = Paths.get("passenger.txt");
		List<String> list = Files.readAllLines(path);

		for (String line : list) {

			String[] row = line.split(",");
			String username1 = row[1];
			String password1 = row[2];
			int userid1 = Integer.parseInt(row[0]);
			String emailid1 = row[3];
			long phone = Long.parseLong(row[4]);
			String gender1 = row[5];
			java.sql.Date dob1 = java.sql.Date.valueOf(row[6]);
			String city = row[7];

			Register obj = new Register();
			obj.setUserid(userid1);
			obj.setUsername(username1);
			obj.setPassword(password1);
			obj.setEmailid(emailid1);
			obj.setPhonenum(phone);
			obj.setGender(gender1);
			obj.setDob(dob1);
			obj.setCityname(city);

			System.out.println(obj);
			RegistrationImplementation.save(obj);

		}

	}
}

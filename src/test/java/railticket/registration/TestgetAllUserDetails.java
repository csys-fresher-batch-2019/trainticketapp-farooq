package railticket.registration;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import railticket.registration.Register;
import railticket.registration.RegistrationImplementation;

public class TestgetAllUserDetails {

	public static void main(String[] args) throws Exception {
		RegistrationImplementation obj = new RegistrationImplementation();
		 obj.getAllUserDetails();
		
			List<Register> reg = obj.getAllUserDetails();
			String fileContent = "";
			
			for (Register r : reg) {
				String line = "username="+r.getUsername()+","+"user-id="+r.getUserid()+","+"email-id="+r.getEmailid()+","+"gender="+r.getGender()+","+"password="+r.getPassword()+","+"cityname="+r.getCityname()+",";
				fileContent = fileContent+line+"\n";
			}
		System.out.println(fileContent);
		
		Path path = Paths.get("alluserdetails.txt");
		Files.write(path,fileContent.getBytes() , StandardOpenOption.APPEND);
		
		}

}

	
package railticket.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import railticket.registration.Register;

public interface RegistrationDAO {

	
	public void registrationInsert(String username,String password,String emailid,long phonenumber,String gender,LocalDate dob,String cityname) throws Exception;
	
	public String getUserPassword(String emailid) throws Exception;
	
	
	public void changePassword(String emailid,String pass) throws Exception;
	
	public void changephonenum (int userid,long phonenumber)throws Exception;
	
	public ArrayList<Register>getAllUserDetails()throws Exception;
	
	public void deleteUser(String emailid)throws Exception;
	
	public void getUserByCity(String city)throws Exception;
	
	public List<Register> getUserDetails(int userid)throws Exception;
	
	public void blockUser(int userid,int status) throws Exception;
	
	
	
}

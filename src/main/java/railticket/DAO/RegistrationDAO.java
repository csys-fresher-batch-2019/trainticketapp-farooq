package railticket.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import railticket.exception.DbException;
import railticket.registration.Register;

public interface RegistrationDAO {

	
	public int registrationInsert(String username,String password,String emailid,long phonenumber,String gender,LocalDate dob,String cityname) throws DbException;
	
	public String getUserPassword(String emailid) throws DbException;
	
	
	public void changePassword(String emailid,String pass) throws DbException;
	
	public void changephonenum (int userid,long phonenumber)throws DbException;
	
	public ArrayList<Register>getAllUserDetails()throws DbException;
	
	public void deleteUser()throws DbException;
	
	public void getUserByCity(String city)throws DbException;
	
	public List<Register> getUserDetails(int userid)throws DbException;
	
	public void blockUser(int userid,int status) throws DbException;
	
	
	
}

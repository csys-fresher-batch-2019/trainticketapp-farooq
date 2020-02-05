package railticket.dao;

import java.time.LocalDate;

import railticket.exception.DbException;


public interface BookingDAO {

	public void checkStatusByPnrNumber(long pnrNumber) throws DbException;

	public int bookSeats(int trainnumber,int userId,String boarding,String destination,int noOfSeats,LocalDate date) throws Exception;

	public void login(String emailid,String password)throws Exception;
	 
	
}

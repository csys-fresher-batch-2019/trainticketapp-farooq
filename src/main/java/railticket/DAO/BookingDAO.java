package railticket.DAO;

import java.time.LocalDate;


public interface BookingDAO {

	public void checkStatusByPnrNumber(long pnrNumber) throws Exception;

	public int bookSeats(int trainnumber,int userId,String boarding,String destination,int noOfSeats,LocalDate date) throws Exception;

	public void login(String emailid,String password)throws Exception;
	 
	
}

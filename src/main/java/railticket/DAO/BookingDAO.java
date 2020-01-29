package railticket.DAO;

import java.time.LocalDate;
//import java.time.LocalDate;


public interface BookingDAO {

	public void checkStatusByPnrNumber(int pnrNumber) throws Exception;

	public void bookSeats(int trainnumber,int userId,String boarding,String destination,int noOfSeats,LocalDate date) throws Exception;

	public void login(String emailid,String password)throws Exception;
	 
	public String berth_type(int s);
	
}

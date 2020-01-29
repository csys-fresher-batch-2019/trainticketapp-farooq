package railticket.Booking;

import railticket.DAO.BookingDAO;
import railticket.booking.Bookingimplements;

public class TestcheckStatusByPnr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	BookingDAO obj = new Bookingimplements();
	try {
		obj.checkStatusByPnrNumber(136905537);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}

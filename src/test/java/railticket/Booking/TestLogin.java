package railticket.Booking;

import railticket.DAO.BookingDAO;
import railticket.booking.Bookingimplements;

public class TestLogin {

	public static void main(String[] args) {
		BookingDAO obj = new Bookingimplements();
		try {
			obj.login("farooq@gmail.com", "p1234");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

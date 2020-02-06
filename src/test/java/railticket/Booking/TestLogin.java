package railticket.Booking;

import railticket.dao.BookingDAO;


import railticket.booking.Bookingimplements;

public class TestLogin {

	public static void main(String[] args) {
		BookingDAO obj = new Bookingimplements();
		try {
			Boolean result=obj.login(1023, "p1234");
			railticket.dao.Logger.getInstance().info(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

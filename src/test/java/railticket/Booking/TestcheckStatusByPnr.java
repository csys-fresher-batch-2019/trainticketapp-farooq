package railticket.Booking;

import railticket.dao.*;
import railticket.booking.Bookingimplements;

public class TestcheckStatusByPnr {

	public static void main(String[] args) {
		
	BookingDAO obj = new Bookingimplements();
	try {
		obj.checkStatusByPnrNumber(136905537);
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}

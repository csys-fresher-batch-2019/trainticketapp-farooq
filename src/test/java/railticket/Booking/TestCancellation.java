package railticket.Booking;

import java.time.LocalDate;

import railticket.booking.Bookingimplements;
import railticket.exception.DbException;

public class TestCancellation {

	public static void main(String[] args) {
		Bookingimplements obj = new Bookingimplements();
		LocalDate travelDate = LocalDate.parse("2020-04-21");

		try {
			obj.Cancellation(1041, 32636, travelDate);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}
}

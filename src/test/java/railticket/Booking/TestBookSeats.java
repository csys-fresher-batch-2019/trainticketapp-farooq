
package railticket.Booking;

import citipe.servicelayer.UserService;

import java.time.LocalDate;

import railticket.DAO.BookingDAO;
import railticket.booking.Bookingimplements;

public class TestBookSeats {

	public static void main(String[] args) {
		BookingDAO obj = new Bookingimplements();
		try {

			LocalDate travelDate = LocalDate.parse("2020-04-22");
			int amt = obj.bookSeats(32636, 1024, "chennai", "Madurai", 6, travelDate);
			
			UserService userService = new UserService();
			long mobileNumber = 9999999999L;
			long originator = 6789012340L;
			int pinNumber = 1234;
			float amount = amt;
			try {
				boolean status = userService.walletTransfer(mobileNumber, originator, pinNumber, amount);
				System.out.println(status);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}

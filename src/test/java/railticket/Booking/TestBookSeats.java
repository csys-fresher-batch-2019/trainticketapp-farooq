
package railticket.Booking;

import java.time.LocalDate;

import railticket.booking.Bookingimplements;
import railticket.client.WalletAPI;
import railticket.dao.BookingDAO;
import railticket.dao.Logger;

public class TestBookSeats {

	public static void main(String[] args) {
		BookingDAO obj = new Bookingimplements();
		
		try {

			LocalDate travelDate = LocalDate.parse("2020-04-21");
			int amt = obj.bookSeats(32636, 1025, "chennai", "Madurai", 6, travelDate);
			
			long mobileNumber = 9999999999L;
			long originator = 6789012340L;
			int pinNumber = 1234;
			float amount = amt;
			try {

				boolean status = WalletAPI.pay(mobileNumber, originator, pinNumber, amount);
				System.out.println(status);
				if(status==true) {
					Logger.getInstance().info("SUCCESSFULLY BOOKED");
				}else {
					Logger.getInstance().info("CANT BOOK TRY AGAIN LATER");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	

}

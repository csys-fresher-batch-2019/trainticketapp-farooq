
package railticket.Booking;

import java.time.LocalDate;

import railticket.DAO.BookingDAO;
import railticket.booking.Bookingimplements;

public class TestBookSeats {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		BookingDAO obj = new Bookingimplements();
		try {
			LocalDate travelDate = LocalDate.parse("2020-04-07");
			obj.bookSeats(32637, 1020,"chennai", "Madurai", 6,travelDate);
			//String seatstype=obj.berth_type(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}

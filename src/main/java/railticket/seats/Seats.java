package railticket.seats;

import java.sql.Date;
import java.time.LocalDate;

public class Seats {
	
	private int trainnumber;
	@Override
	public String toString() {
		return "Seats [trainnumber=" + trainnumber + ", travelDate=" + travelDate + ", availableseats=" + availableseats
				+ "]";
	}
	private Date travelDate;
	private int availableseats;

	public int getTrainnumber() {
		
		return trainnumber;
	}
	public void setTrainnumber(int trainnumber) {
		this.trainnumber = trainnumber;
	}
	public int getAvailableseats() {
		return availableseats;
	}
	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}
	
	public Seats(int trainnumber, int availableseats) {
		this.trainnumber = trainnumber;
		this.availableseats = availableseats;
	}
	public Seats() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date date) {
		this.travelDate = date;
	}
	
}

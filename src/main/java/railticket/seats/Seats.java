package railticket.seats;

public class Seats {
	
	private int trainnumber;
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
	private int availableseats;
	
	public Seats(int trainnumber, int availableseats) {
		this.trainnumber = trainnumber;
		this.availableseats = availableseats;
	}
	public Seats() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TestSeats [trainnumber=" + trainnumber + ", availableseats=" + availableseats + "]";
	}
}

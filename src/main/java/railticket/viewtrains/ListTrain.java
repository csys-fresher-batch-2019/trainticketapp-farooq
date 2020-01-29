package railticket.viewtrains;



public class ListTrain {

	
	public int trainnumber;
	public String trainname;
	public String Boardingstation;
	public String destinationstation;
	public String arrivaltime;
	public String depaturetime;
	public String route;
	public String status;
	public int amount;
		
	
	public ListTrain(int trainnumber, String trainname, String boardingstation, String destinationstation,
			String arrivaltime, String depaturetime, String route, String status,int amount) {
		this.trainnumber = trainnumber;
		this.trainname = trainname;
		this.Boardingstation = boardingstation;
		this.destinationstation = destinationstation;
		this.arrivaltime = arrivaltime;
		this.depaturetime = depaturetime;
		this.route = route;
		this.status = status;
		this.amount= amount;
	}

	public ListTrain() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListTrain [trainnumber=" + trainnumber + ", trainname=" + trainname + ", Boardingstation="
				+ Boardingstation + ", destinationstation=" + destinationstation + ", arrivaltime=" + arrivaltime
				+ ", depaturetime=" + depaturetime + ", route=" + route + ", status=" + status + ", amount=" + amount
				+ "]";
	}

	
}

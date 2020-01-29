package railticket.viewtrains;



public class ListTrain {

	
	public int getTrainnumber() {
		return trainnumber;
	}

	public void setTrainnumber(int trainnumber) {
		this.trainnumber = trainnumber;
	}

	public String getTrainname() {
		return trainname;
	}

	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}

	public String getBoardingstation() {
		return Boardingstation;
	}

	public void setBoardingstation(String boardingstation) {
		Boardingstation = boardingstation;
	}

	public String getDestinationstation() {
		return destinationstation;
	}

	public void setDestinationstation(String destinationstation) {
		this.destinationstation = destinationstation;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getDepaturetime() {
		return depaturetime;
	}

	public void setDepaturetime(String depaturetime) {
		this.depaturetime = depaturetime;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	private int trainnumber;
	private String trainname;
	private String Boardingstation;
	private String destinationstation;
	private String arrivaltime;
	private String depaturetime;
	private String route;
	private String status;
	private int amount;
		
	
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

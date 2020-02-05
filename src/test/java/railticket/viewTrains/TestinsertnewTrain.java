package railticket.viewTrains;

import railticket.viewtrains.ListTrain;
import railticket.viewtrains.ViewTrainsimplementation;

public class TestinsertnewTrain {

	public static void main(String[] args) {
		ViewTrainsimplementation obj = new ViewTrainsimplementation();
		ListTrain lt = new ListTrain();
		lt.setTrainnumber(32639);
		lt.setTrainname("perl city express");
		lt.setBoardingstation("Chennai Egmore");
		lt.setDestinationstation("Toothikudi");
		lt.setDepaturetime("08:00:00");
		lt.setArrivaltime("02:00:00");
		lt.setRoute("Egmore-madurai-toothukudi");
		lt.setStatus("not available");
		lt.setAmount(300);
		try {
	obj.insertnewTrain(lt);
} catch (Exception e) {
	e.printStackTrace();
}
	}

}

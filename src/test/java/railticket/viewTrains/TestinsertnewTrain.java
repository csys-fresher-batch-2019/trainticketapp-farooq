package railticket.viewTrains;

import railticket.viewtrains.ListTrain;
import railticket.viewtrains.ViewTrainsimplementation;

public class TestinsertnewTrain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ViewTrainsimplementation obj = new ViewTrainsimplementation();
		ListTrain lt = new ListTrain();
		lt.trainnumber = 32639;
		lt.trainname = "perl city express";
		lt.Boardingstation="Chennai Egmore";
		lt.destinationstation="Toothikudi";
		lt.depaturetime="08:00:00";
		lt.arrivaltime="02:00:00";
		lt.route="Egmore-madurai-toothukudi";
		lt.status="not available";
		lt.amount=300;
		try {
	obj.insertnewTrain(lt);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}

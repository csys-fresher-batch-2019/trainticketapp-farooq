package railticket.viewTrains;

import java.util.ArrayList;

import railticket.viewtrains.ListTrain;
import railticket.viewtrains.ViewTrainsimplementation;

public class TestgetTrainsByArrTime {

	public static void main(String[] args){
ViewTrainsimplementation obj = new ViewTrainsimplementation();
		ArrayList<ListTrain> obj1;
		try {
			obj1 = obj.getTrainsByArrivalTime();
			System.out.println(obj1);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}}


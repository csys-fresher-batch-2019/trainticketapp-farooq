package railticket.viewTrains;

import java.time.LocalDate;
import java.util.ArrayList;

import railticket.viewtrains.ListTrain;
import railticket.viewtrains.ViewTrainsimplementation;

public class TestGetTrainDetails {

	public static void main(String[] args) {

		ViewTrainsimplementation obj = new ViewTrainsimplementation();
		try {
			LocalDate traveldate = LocalDate.parse("2020-04-21");
			ArrayList<ListTrain> obj1=obj.getTrainDetails("chennai", "madurai",traveldate);
			System.out.println(obj1);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}

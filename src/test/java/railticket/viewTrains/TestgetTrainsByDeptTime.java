package railticket.viewTrains;

import java.util.ArrayList;

import railticket.viewtrains.ListTrain;
import railticket.viewtrains.ViewTrainsimplementation;

public class TestgetTrainsByDeptTime {

	public static void main(String[] args) {
		ViewTrainsimplementation obj = new ViewTrainsimplementation();
		try {
			ArrayList<ListTrain> obj1 = obj.getTrainsByDeptTime();

			System.out.println(obj1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

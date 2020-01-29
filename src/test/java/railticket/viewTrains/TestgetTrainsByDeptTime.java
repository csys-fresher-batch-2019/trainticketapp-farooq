package railticket.viewTrains;

import java.util.ArrayList;

import railticket.viewtrains.ListTrain;
import railticket.viewtrains.ViewTrainsimplementation;

public class TestgetTrainsByDeptTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ViewTrainsimplementation obj = new ViewTrainsimplementation();
		try {
			ArrayList<ListTrain> obj1 = obj.getTrainsByDeptTime();

			System.out.println(obj1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

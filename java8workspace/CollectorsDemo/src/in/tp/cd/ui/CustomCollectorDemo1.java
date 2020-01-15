package in.tp.cd.ui;

import java.util.Map;

import in.tp.cd.dao.EmployeeRepo;
import in.tp.cd.util.DesgWiseCountCollector;

public class CustomCollectorDemo1 {

	public static void main(String[] args) {
		Map<String,Integer> desgCountMap=
				(new EmployeeRepo()).getAllEmps().stream()
				.collect(new DesgWiseCountCollector());
		System.out.println(desgCountMap);
	}

}

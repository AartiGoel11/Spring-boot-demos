package in.tp.cd.ui;

import java.util.Map;

import in.tp.cd.dao.EmployeeRepo;
import in.tp.cd.util.DesgWiseCountCollector;
import in.tp.cd.util.JoinYearWiseCountCollector;

public class CustomCollectorDemo4 {

	public static void main(String[] args) {
		Map<Integer,Integer> joinYearCountMap=
				(new EmployeeRepo()).getAllEmps().stream()
				.collect(new JoinYearWiseCountCollector());
		System.out.println(joinYearCountMap);
	}

}

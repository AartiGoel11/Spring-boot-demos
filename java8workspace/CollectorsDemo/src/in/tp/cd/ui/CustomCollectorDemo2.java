package in.tp.cd.ui;

import java.util.HashMap;
import java.util.Map;

import in.tp.cd.dao.EmployeeRepo;
import in.tp.cd.util.DesgWiseCountCollector;

public class CustomCollectorDemo2 {

	public static void main(String[] args) {
		Map<Integer,Integer> joinYearCountMap=
				(new EmployeeRepo()).getAllEmps().stream()
				.collect(
						HashMap<Integer,Integer>::new,
						(map,emp) -> { map.merge(emp.getJoinDate().getYear(),1,(a,b)->(a+1));},
						(map1,map2) -> {map2.forEach((k,v)->{map1.merge(k, v, (v1,v2)->(v1+v2));});}
						);
		System.out.println(joinYearCountMap);
	}

}

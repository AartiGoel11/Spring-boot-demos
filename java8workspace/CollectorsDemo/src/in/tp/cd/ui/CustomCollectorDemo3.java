package in.tp.cd.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;

import in.tp.cd.dao.EmployeeRepo;
import in.tp.cd.model.Employee;
import in.tp.cd.util.DesgWiseCountCollector;

public class CustomCollectorDemo3 {

	public static void main(String[] args) {
		/*TreeMap<Integer,Integer> joinYearCountMap=
				(new EmployeeRepo()).getAllEmps().stream()
				.collect(Collector.
						<Employee,TreeMap<Integer,Integer>,TreeMap<Integer,Integer>>
						of(
						TreeMap<Integer,Integer>::new, 
						(map,emp) -> { map.merge(emp.getJoinDate().getYear(),1,(a,b)->(a+1));}, 
						(map1,map2) -> {map2.forEach((k,v)->{map1.merge(k, v, (v1,v2)->(v1+v2)); return map1;});}, 
						Function.identity(), 
						new Characteristics[] {})
						);
		System.out.println(joinYearCountMap);*/
	}

}

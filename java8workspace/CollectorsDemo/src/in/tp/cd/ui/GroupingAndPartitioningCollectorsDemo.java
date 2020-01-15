package in.tp.cd.ui;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import in.tp.cd.dao.EmployeeRepo;
import in.tp.cd.model.Employee;

public class GroupingAndPartitioningCollectorsDemo {

	public static void main(String[] args) {
		List<Employee> empList = (new EmployeeRepo()).getAllEmps();
		
		Map<String, List<Employee>> desgWiseGroup = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDesignation));
		System.out.println(desgWiseGroup);

		Map<Boolean, List<Employee>> payPartitions = empList.stream()
				.collect(Collectors.partitioningBy(e->e.getBasic()>=25000));
		System.out.println(payPartitions);
	}

}

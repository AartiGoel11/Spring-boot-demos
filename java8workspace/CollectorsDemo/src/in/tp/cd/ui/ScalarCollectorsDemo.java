package in.tp.cd.ui;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import in.tp.cd.dao.EmployeeRepo;
import in.tp.cd.model.Employee;

public class ScalarCollectorsDemo {

	public static void main(String[] args) {
		
		List<Employee> empList = (new EmployeeRepo()).getAllEmps();
		
		System.out.println(
		empList.stream()
		.map(e -> e.getFirstName())
		.collect(Collectors.joining("\n")));
				
		System.out.println(
				empList.stream()
				.filter(e -> "Manager".equals(e.getDesignation()))
				.count() + " managers");
		
		Long count = empList.stream().collect(Collectors.counting());
		System.out.println(count);
		
		Double totalBasic = empList.stream()
				.collect(Collectors.summingDouble(Employee::getBasic));
		System.out.println(totalBasic);
		
		Double avgBasic = empList.stream()
				.collect(Collectors.averagingDouble(Employee::getBasic));
		System.out.println(avgBasic);
		
		DoubleSummaryStatistics summary = empList.stream().collect(
				Collectors.summarizingDouble(Employee::getBasic));
		
		System.out.println(summary.toString());
	}
}

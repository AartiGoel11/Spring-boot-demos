package in.tp.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import in.tp.model.Employee;
import in.tp.service.EmployeeService;

public class StreamsDemo1 {

	public static void main(String[] args) {
		Employee[] emps = new Employee[] {
				new Employee(101,LocalDate.of(1999,1,11),12,5,5.65),
				new Employee(101,LocalDate.of(1999,1,11),12,12,4.65),
				new Employee(101,LocalDate.of(2000,10,11),5,5,5.65),
				new Employee(101,LocalDate.of(2005,1,11),4,5,7.65),
				new Employee(101,LocalDate.of(2002,1,11),8,15,10.65)
		};
		
		Arrays.stream(emps).forEach(System.out::println);
		Arrays.stream(emps).forEach((e)->{
			e.setExperience(EmployeeService.getExperience(e));});
		Arrays.stream(emps).forEach(System.out::println);
		Arrays.stream(emps).map((e)->e.getEmpNo()).forEach(System.out::println);
		
		Optional<Employee> result= Arrays.stream(emps)
				.reduce((e1,e2)-> e1.getExperience()>e2.getExperience()?e1:e2);
		if(result.isPresent())
			System.out.println(result.get());
		
		List<Employee> expereincedEmps = Arrays.stream(emps)
				.filter((e) -> e.getExperience()>=9)
				.collect(Collectors.toList());
	
		
	}

}

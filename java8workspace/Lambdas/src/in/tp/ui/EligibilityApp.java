package in.tp.ui;

import java.time.LocalDate;
import java.util.Arrays;

import in.tp.model.Employee;
import in.tp.service.EmployeeService;

public class EligibilityApp {

	public static void main(String[] args) {
		
		Employee[] emps = new Employee[] {
				new Employee(101,LocalDate.of(1999,1,11),12,5,5.65),
				new Employee(101,LocalDate.of(1999,1,11),12,12,4.65),
				new Employee(101,LocalDate.of(2000,10,11),5,5,5.65),
				new Employee(101,LocalDate.of(2005,1,11),4,5,7.65),
				new Employee(101,LocalDate.of(2002,1,11),8,15,10.65)
		};
		
		System.out.println(
				EmployeeService.filter(Arrays.asList(emps), 
						(e)->e.getProjectsCount()>=4 && e.getSkillCount()>=10)
				);
		
		System.out.println(
				EmployeeService.filter(Arrays.asList(emps), 
						(e)->EmployeeService.getExperience(e)>=6)
				);
		
	}

}

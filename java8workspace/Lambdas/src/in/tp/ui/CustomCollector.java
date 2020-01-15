package in.tp.ui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import in.tp.model.Employee;

public class CustomCollector {
	public static void main(String[] args) {
		
		Employee[] emps = new Employee[] {
				new Employee(101,LocalDate.of(1999,1,11),12,5,5.65),
				new Employee(101,LocalDate.of(1999,1,11),12,12,4.65),
				new Employee(101,LocalDate.of(2000,10,11),5,5,5.65),
				new Employee(101,LocalDate.of(2005,1,11),4,5,7.65),
				new Employee(101,LocalDate.of(2002,1,11),8,15,10.65)
		};
		
		
	}
}

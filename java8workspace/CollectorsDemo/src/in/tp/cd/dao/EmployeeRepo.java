package in.tp.cd.dao;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import in.tp.cd.model.Employee;

public class EmployeeRepo {
	
	private List<Employee> emps=null;
	
	public EmployeeRepo() {
		emps = Arrays.asList(new Employee[] {
				new Employee(101,"Vamsy","Kiran",LocalDate.of(2001,1,1),"Sr.Assosiate",25000),
				new Employee(102,"Vasu","Nath",LocalDate.of(2004,1,1),"Jr.Assosiate",15000),
				new Employee(103,"Srinu","",LocalDate.of(2000,1,1),"Manager",55000),
				new Employee(104,"Ramana","Murthy",LocalDate.of(2002,1,1),"Sr.Assosiate",35000),
				new Employee(105,"Seeta","Lakshmi",LocalDate.of(2002,8,1),"Sr.Assosiate",37000),
				new Employee(106,"Sravan","Kumar",LocalDate.of(2003,1,1),"Jr.Assosiate",10000),
				new Employee(107,"Muthu","Samy",LocalDate.of(2003,1,1),"Sr.Assosiate",25000),
				new Employee(108,"Latha","",LocalDate.of(2002,1,1),"Jr.Assosiate",15000),
				new Employee(109,"Kiranmayee","Prabha",LocalDate.of(2000,1,1),"Manager",75000),
				new Employee(110,"Usha","Pavani",LocalDate.of(2009,1,1),"Jr.Assosiate",9000),
		}); 
	}
 
	public List<Employee> getAllEmps() {
		return emps;
	}
}

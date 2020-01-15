package in.tp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.tp.model.Employee;

public class EmployeeService {
	
	public static int getExperience(Employee emp) {
		LocalDate today = LocalDate.now();
		return today.getYear()-emp.getDateOfJoining().getYear();
	}

	public static List<Long> filter(List<Employee> org,EligibilityService els){
		List<Long> result=null;
		
		if(org!=null && org.size()>0) {
			result=new ArrayList<>();
			for(Employee emp : org) {
				if(els.isEligible(emp))
					result.add(emp.getEmpNo());
			}
		}
		
		return result;
	}
}

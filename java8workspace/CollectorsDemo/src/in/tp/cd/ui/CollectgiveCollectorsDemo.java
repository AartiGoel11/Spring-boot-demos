package in.tp.cd.ui;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import in.tp.cd.dao.EmployeeRepo;
import in.tp.cd.model.Employee;

public class CollectgiveCollectorsDemo {

	public static void main(String[] args) {
		
		EmployeeRepo repo = new EmployeeRepo();
		List<Employee> empList = repo.getAllEmps();
		
		Set<String> fnmSet = empList.stream()
				.map(e->e.getFirstName())
				.collect(Collectors.toSet());
		System.out.println(fnmSet);
		
		List<Employee> managersList = empList.stream()
				.filter(e->"Manager".equals(e.getDesignation()))
				.collect(Collectors.toList());
		System.out.println(managersList);
		
		Map<Integer, String> empNoLnmMap = empList.stream()
				.collect(Collectors.toMap(Employee::getEmpNo, Employee::getLastName));
		System.out.println(empNoLnmMap);
		
		Map<Integer, String> empNoFullNameMap = empList.stream()
				.collect(Collectors.toMap(
						Employee::getEmpNo,
						(e) -> (e.getFirstName() +" " + e.getLastName()).trim()
						));
		System.out.println(empNoFullNameMap);
		
	}

}

package in.tp.cd.model;

import java.time.LocalDate;

public class Employee {

	private int empNo;
	private String firstName;
	private String lastName;
	private LocalDate joinDate;
	private String designation;
	private double basic;
	
	public Employee() {}

	public Employee(int empNo, String firstName, String lastName, LocalDate joinDate, String designation,
			double basic) {
		super();
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.joinDate = joinDate;
		this.designation = designation;
		this.basic = basic;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", firstName=" + firstName + ", lastName=" + lastName + ", joinDate="
				+ joinDate + ", designation=" + designation + ", basic=" + basic + "]";
	}
	
	
}

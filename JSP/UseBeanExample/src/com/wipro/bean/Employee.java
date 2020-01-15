package com.wipro.bean;

public class Employee {
	private int empid;
	private String name;
	private String address;
	private int age;
	private double salary;
	
	public Employee() {
		empid=0;
		name="";
		address="Hyderabad";
		age=21;
		salary=250000.00;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}

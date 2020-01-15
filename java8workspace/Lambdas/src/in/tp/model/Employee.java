package in.tp.model;

import java.time.LocalDate;

public class Employee {

	private long empNo;
	private LocalDate dateOfJoining;
	private int projectsCount;
	private int skillCount;
	private double avgRegScore;
	private int experience;

	public Employee() {
	}

	public Employee(long empNo, LocalDate dateOfJoining, int projectsCount, int skillCount, double avgRegScore) {
		super();
		this.empNo = empNo;
		this.dateOfJoining = dateOfJoining;
		this.projectsCount = projectsCount;
		this.skillCount = skillCount;
		this.avgRegScore = avgRegScore;
	}

	public long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(long empNo) {
		this.empNo = empNo;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getProjectsCount() {
		return projectsCount;
	}

	public void setProjectsCount(int projectsCount) {
		this.projectsCount = projectsCount;
	}

	public double getAvgRegScore() {
		return avgRegScore;
	}

	public void setAvgRegScore(double avgRegScore) {
		this.avgRegScore = avgRegScore;
	}

	public int getSkillCount() {
		return skillCount;
	}

	public void setSkillCount(int skillCount) {
		this.skillCount = skillCount;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", dateOfJoining=" + dateOfJoining + ", projectsCount=" + projectsCount
				+ ", skillCount=" + skillCount + ", avgRegScore=" + avgRegScore + ", experience=" + experience + "]";
	}

	
}

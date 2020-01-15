package in.tp.service;

import in.tp.model.Employee;

@FunctionalInterface
public interface EligibilityService {
	boolean isEligible(Employee emp);
}

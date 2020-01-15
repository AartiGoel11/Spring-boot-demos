package in.tp.service;

public class GreetingServiceTeluguImpl implements GreetingService{

	@Override
	public String greetUser(String userName) {
		return "Namaskaram "+userName;
	}

}

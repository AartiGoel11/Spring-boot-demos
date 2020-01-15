package in.tp.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import in.tp.service.GreetingService;
import in.tp.service.GreetingServiceTeluguImpl;

public class GreetApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("UserName: ");
		String unm = scan.nextLine();
		
		GreetingService service = new GreetingServiceTeluguImpl();
		System.out.println(service.greetUser(unm));
	
		GreetingService service2 = new GreetingService() {

			@Override
			public String greetUser(String userName) {
				return "Hello " + userName;
			}
			
		};
		
		System.out.println(service2.greetUser(unm));
		
		GreetingService service3 = (nm) -> "Vanakkam "+nm; 
		System.out.println(service3.greetUser(unm));
		
		GreetingService service4 = (nm) -> {
			String greet="";
			
			int hour = LocalDateTime.now().getHour();
			
			if(hour>=4) greet="Good Morning";
			else if(hour>=12) greet="Good Noon";
			else greet="Good Evening";
			
			return greet+nm;
		};
		System.out.println(service4.greetUser(unm));
	}

}

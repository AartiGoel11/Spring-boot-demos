package in.tp.led.ui;

import java.time.LocalDateTime;

import in.tp.led.service.InfoSupplier;

public class InfoSupplierDemo {

	public static void main(String[] args) {
		
		InfoSupplier orgTitle = () -> "CGI"; 		
		System.out.println(orgTitle.getInfo());
		
		InfoSupplier greeting = () -> {
			String greet="";
			int hour = LocalDateTime.now().getHour();
			
			if(hour>=4 && hour <=11) greet="Good Morning";
			else if(hour<=15) greet="Good Afternoon";
			else if(hour<=20) greet="Good Evening";
			else greet="Good Night";
			
			return greet;
		};		
		System.out.println(greeting.getInfo());
	}
}

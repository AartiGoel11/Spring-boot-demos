package in.tp.dts.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Datemanipuklations {

	public static void main(String[] args) {
		DateTimeFormatter myformat = DateTimeFormatter.ofPattern("MMM,dd-yyyy");
		
		LocalDate today = LocalDate.now();
		System.out.println(today.format(myformat));
		System.out.println(today.plusDays(150).format(myformat));

	}

}

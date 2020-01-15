package in.tp.dts.ui;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ComputeAgeFromDob {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		System.out.println("Enter DOB('dd-MM-yyyy'): ");
		String dobStr = scan.next();
		
		LocalDate dob = LocalDate.parse(dobStr,format);
		LocalDate today = LocalDate.now();

		System.out.println(dob.format(format));
		System.out.println(today.format(format));
		System.out.println(Period.between(dob, today).toTotalMonths()/12.0);
		scan.close();

	}

}

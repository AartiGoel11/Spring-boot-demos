package in.tp.dts.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.format.DateTimeFormatter.*;

public class FormatsDemo {
	public static void main(String[] a) {
		LocalDate today = LocalDate.now();
		LocalDateTime currentTime = LocalDateTime.now();
		
		
		System.out.println(today.format(ISO_DATE));
		System.out.println(currentTime.format(ISO_DATE_TIME));
		System.out.println(today.format(ISO_LOCAL_DATE));
		System.out.println(currentTime.format(ISO_LOCAL_DATE_TIME));

	}
}

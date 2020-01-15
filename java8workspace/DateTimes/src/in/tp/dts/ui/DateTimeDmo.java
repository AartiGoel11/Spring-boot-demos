package in.tp.dts.ui;

import java.beans.IndexedPropertyChangeEvent;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class DateTimeDmo {

	public static void main(String[] args) {
		
		LocalDate independenceDay = LocalDate.of(1947, Month.AUGUST, 15);
		LocalDate today = LocalDate.now();
		Period period =Period.between(independenceDay, today);
		System.out.println(independenceDay);
		System.out.println(today);
		System.out.println(period);
		System.out.println(period.getYears());
		System.out.println(period.toTotalMonths()/12.0);
	}

}

package in.tp.led.ui;

import in.tp.led.service.IsUsableNumberPredicate;

public class IsUsableNumberPredicateDemo {

	public static void main(String[] args) {

		IsUsableNumberPredicate forClassValue = 
				(num) -> (num >= 1 && num <= 12);
		
		System.out.println(forClassValue.IsUsableNumber(15));
		System.out.println(forClassValue.IsUsableNumber(-10));
		System.out.println(forClassValue.IsUsableNumber(8));
		
		IsUsableNumberPredicate forAge =
				(num) -> (num >= 1 && num <= 120);
		
		System.out.println(forAge.IsUsableNumber(15));
		System.out.println(forAge.IsUsableNumber(-10));
		System.out.println(forAge.IsUsableNumber(8));
		
	}

}

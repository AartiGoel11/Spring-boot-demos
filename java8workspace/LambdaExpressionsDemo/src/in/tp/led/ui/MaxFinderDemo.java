package in.tp.led.ui;

import in.tp.led.dto.Book;
import in.tp.led.service.MaxFinder;

public class MaxFinderDemo {

	public static void main(String[] args) {

		MaxFinder<Integer> inInts = (a, b) -> (a > b ? a : b);
		System.out.println(inInts.max(12, 89));

		MaxFinder<String> inStrs = (a, b) -> (a.compareTo(b)>0 ? a : b);
		System.out.println(inStrs.max("apple", "Mango"));

		Book b1 = new Book("b001", "Let Us C", 123, 1);
		Book b2 = new Book("b002", "Let Us C++", 110, 4);

		MaxFinder<Book> inBooksByPrice = (a, b) -> 
			(a.getPrice() > b.getPrice() ? a: b);
		
		MaxFinder<Book> inBooksByTitle = (a, b) -> 
		( a.getTitle().compareTo(b.getTitle()) >= 0 ? a : b );
		
		
		System.out.println(inBooksByPrice.max(b1, b2));
		System.out.println(inBooksByTitle.max(b1, b2));
	}

}

package in.tp.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import in.tp.model.Book;

public class CollectingToMapDemo {

	public static void main(String[] args) {
		Book[] books = new Book[] {
				new Book("b001", "Let Us C", 123, 1),
				new Book("b002", "Let Us C++", 110, 4)
		};
		
		Map<String,String> data = Arrays.stream(books).collect(Collectors
				.toMap(Book::getBookCode, Book::getTitle));
		System.out.println(data);
	}

}

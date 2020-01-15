package in.tp.streams.ui;

import java.util.ArrayList;
import java.util.List;

import in.tp.led.dto.Book;

public class BookNameFiltering {
	public static void main(String a[]){
		
		List<Book> books = new ArrayList<Book>();
		
		books.add(new Book("B001","Let Us C",256,12));
		books.add(new Book("B002","Let Us C++",1256,12));
		books.add(new Book("B003","Complete eReference",2256,12));
		books.add(new Book("B004","The Houdns Story",2516,12));
				
		books.stream().map(book -> book.getTitle()).forEach(System.out::println);
	}
	
}

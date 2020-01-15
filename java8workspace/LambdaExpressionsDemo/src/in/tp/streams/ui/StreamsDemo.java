package in.tp.streams.ui;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class StreamsDemo {

	public static void main(String[] args) {
		
		Stream<Integer> intStream = Stream.of(10,20,30,40,-10,90);
		intStream.forEach(System.out::println);
		
		int[] nums = new int[] {11,12,13,14,15,16,17,18,19,20};
		Arrays.stream(nums).forEach(System.out::println);
				
		OptionalInt sum = Arrays.stream(nums).reduce((a,b)->a+b);
		if(sum.isPresent())
			System.out.println("Sum: "+sum.getAsInt());
		
		OptionalInt prd = Arrays.stream(nums).reduce((a,b)->a*b);
		if(prd.isPresent())
			System.out.println("Prd: "+prd.getAsInt());
		
		OptionalInt min = Arrays.stream(nums).reduce((a,b)->(a<b?a:b));
		if(min.isPresent())
			System.out.println("Min: "+min.getAsInt());
		
		OptionalInt max = Arrays.stream(nums).reduce((a,b)->(a>b?a:b));
		if(max.isPresent())
			System.out.println("Max: "+max.getAsInt());
		
		System.out.println("Even numbers: ");
		Arrays.stream(nums)
			.filter((a)->a%2==0)
			.forEach(System.out::println);
		
		System.out.println("Squares: ");
		Arrays.stream(nums)
			.map((a)->a*a)
			.forEach(System.out::println);
		
		System.out.println("Square Roots: ");
		Arrays.stream(nums)
			.mapToDouble(a->Math.sqrt(a))
			.forEach(System.out::println);
		
	}

}

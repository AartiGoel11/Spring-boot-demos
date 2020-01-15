package in.tp.ui;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import in.tp.service.MathService;

public class ParellelStreamApp {

	public static void main(String[] args) {
		MathService service = new MathService();
		
		Integer[] numbers = service.range(10, 500);
		
		LocalDateTime begin = LocalDateTime.now();
		List<Integer> result= Arrays.stream(numbers)
								.filter(service::isPrime)
								.collect(Collectors.toList());
		System.out.println(result);
		LocalDateTime end = LocalDateTime.now();
		Duration dur = Duration.between(begin, end);
		System.out.println("Took "+dur.toMillis()+" ms");
		
		begin = LocalDateTime.now();
		Arrays.stream(numbers).parallel()
				.filter(service::isPrime)
				.forEach(System.out::println);
		end = LocalDateTime.now();
		dur = Duration.between(begin, end);
		System.out.println("Took "+dur.toMillis()+" ms");
	}

}

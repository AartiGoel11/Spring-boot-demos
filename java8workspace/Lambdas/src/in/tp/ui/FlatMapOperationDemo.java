package in.tp.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FlatMapOperationDemo {

	public static void main(String[] args) {
		String[][] names = new String[][] {
			{"Ram","Ravi","Sagar"},
			{"Pallavi","Rajesh","Lok","Prem","Varun"},
			{"Vamsy","Srinu","Venky","Suseela"}
		};
		
		List<String> namesAll = Arrays.stream(names)
		.flatMap( subArray -> Arrays.stream(subArray))
		.collect(Collectors.toList());
		
		System.out.println(namesAll);
		
		List<List<String>> jaggedList = Arrays.stream(names)
				.map(subArray -> Arrays.asList(subArray))
				.collect(Collectors.toList());
		System.out.println(jaggedList);
		
		List<String> flattedList = jaggedList.stream()
				.flatMap(subList -> subList.stream())
				.collect(Collectors.toList());
		System.out.println(flattedList);
		
		Supplier<Map<String,List<String>>> sup =TreeMap<String,List<String>>::new;
		BiConsumer<Map<String,List<String>>, String> accum =
				(map,str) -> {
					String key = str.charAt(0)+"";
					map.putIfAbsent(key, Collections.emptyList());
					map.get(key).add(str);
					};
		
		BiConsumer<Map<String,List<String>>, Map<String,List<String>>> comb =
				(map1,map2) ->{
					map2.forEach((k,v)->{
						map1.putIfAbsent(k, Collections.emptyList());
						map1.get(k).addAll(v);
					});
				};
		Map<String,List<String>> namesMap = flattedList.stream()
				.collect(sup,accum,comb);
		System.out.println(namesMap);
	}

}

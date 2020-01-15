package in.tp.cd.util;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

import in.tp.cd.model.Employee;

public class JoinYearWiseCountCollector implements Collector<Employee, Map<Integer,Integer>, Map<Integer,Integer>>{

	@Override
	public BiConsumer<Map<Integer, Integer>, Employee> accumulator() {
		return (map,emp) -> {
			map.merge(emp.getJoinDate().getYear(), 1,(a,b)->a+1 );
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

	@Override
	public BinaryOperator<Map<Integer, Integer>> combiner() {
		return (map1,map2) -> {
			map2.forEach((k,v)->{
				map1.merge(k, v, (v1,v2)->v1+v2);
			});
			return map1;
		};
	}

	@Override
	public Function<Map<Integer, Integer>, Map<Integer, Integer>> finisher() {
		return (x)->{
			Integer first = ((TreeMap<Integer,Integer>)x).firstKey();
			Integer last = ((TreeMap<Integer,Integer>)x).lastKey();
			
			for(int i=first;i<=last;i++)
				x.putIfAbsent(i, 0);
						
			return x;
		};
		//return Function<Map<String, Integer>, Map<String, Integer>>::identity;
	}

	@Override
	public Supplier<Map<Integer, Integer>> supplier() {
		return TreeMap<Integer,Integer>::new;
	}

}

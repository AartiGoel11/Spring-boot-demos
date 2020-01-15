package in.tp.cd.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import in.tp.cd.model.Employee;

public class DesgWiseCountCollector implements Collector<Employee, Map<String,Integer>, Map<String,Integer>>{

	@Override
	public BiConsumer<Map<String, Integer>, Employee> accumulator() {
		return (map,emp) -> {
			map.merge(emp.getDesignation(), 1,(a,b)->a+1 );
			
			/*String key=emp.getDesignation();
			if(map.containsKey(key))
				map.replace(key, map.get(key)+1);
			else
				map.put(key, 1);*/
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.singleton(Characteristics.IDENTITY_FINISH);
	}

	@Override
	public BinaryOperator<Map<String, Integer>> combiner() {
		return (map1,map2) -> {
			map2.forEach((k,v)->{
				map1.merge(k, v, (v1,v2)->v1+v2);
			});
			return map1;
		};
	}

	@Override
	public Function<Map<String, Integer>, Map<String, Integer>> finisher() {
		return (x)->x;
		//return Function<Map<String, Integer>, Map<String, Integer>>::identity;
	}

	@Override
	public Supplier<Map<String, Integer>> supplier() {
		return HashMap<String,Integer>::new;
		//return () -> (new HashMap<String,Integer>());
	}

}

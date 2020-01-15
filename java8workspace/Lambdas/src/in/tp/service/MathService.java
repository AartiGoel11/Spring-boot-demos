package in.tp.service;

import java.util.ArrayList;
import java.util.List;

public class MathService {

	public Integer[] range(int lb,int ub) {
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i=lb;i<=ub;i++)
			numbers.add(i);
		
		return numbers.toArray(new Integer[] {});
	}
	
	public boolean isPrime(int x) {
		boolean flag=true;
		for(int i=2;i<=x/2;i++) { 
			if(x%i==0) {
				flag=false;
				break;
			}
		}
		return flag;
	}
}

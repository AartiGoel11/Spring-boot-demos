package in.tp.led.ui;

import in.tp.led.service.InfoConsumer;

public class InfoConsumerDemo {

	public static void main(String[] args) {

		InfoConsumer horzRepeater = (str,n) -> {			
			for(int i=0;i<n;i++)
				System.out.print(str +"\t");
			System.out.println("");
		}; 
		
		InfoConsumer vertRepeater = (str,n) -> {
			System.out.println("-----------------------------");
			for(int i=0;i<n;i++)
				System.out.println(str);
			System.out.println("-----------------------------");
		}; 

		horzRepeater.repeat("RAMA", 10);
		vertRepeater.repeat("RAMA", 10);
	}

}

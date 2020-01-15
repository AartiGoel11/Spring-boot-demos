package in.tp.j8f.ui;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

public class ParallelSort {

	public static void main(String[] args) {
		Random random = new Random();
		int[] nums = new int[10000];
		
		for(int i=0;i<10000;i++)
			nums[i]=random.nextInt(15000);
		
		LocalDateTime start=null,end=null;
		
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		start = LocalDateTime.now();
		Arrays.sort(nums2);
		end = LocalDateTime.now();
		System.out.println(nums2);
		System.out.println(Duration.between(start, end).toMillis());
		
		int[] nums3 = Arrays.copyOf(nums, nums.length);
		start = LocalDateTime.now();
		Arrays.parallelSort(nums3);
		end = LocalDateTime.now();
		System.out.println(nums3);
		System.out.println(Duration.between(start, end).toMillis());

	}

}

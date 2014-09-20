package doublingTest;

import java.util.Arrays;

public class TwoSumFast {
	
	/**
	 * Counts the number of pairs in the given integer array which sum to zero.
	 * i.e. a[i] + a[j] = 0.
	 * 
	 * A mathematic model of the running time is:
	 * 
	 * 	T(N) ~ aNlogN
	 * 
	 * where a is some machine dependent constant.
	 * 
	 * Implemented a faster algorithm for finding pairs of integers that sum to zero 
	 * (twoSum). It assumes that all integers in the array are unique. 
	 * 
	 * The algorithm first sorts the input array in place. Then, for each 
	 * integer in the array, it proceeds to find the array index of an integer which 
	 * might cancel out the subject integer (i.e. sum to zero).
	 * 
	 * If an integer is found which cancels the subject integer, AND it appears 
	 * after the subject in the sorted array, count is incremented.
	 * If, however, the cancelling integer appears before the subject integer, 
	 * it's not counted, to avoid double counting.
	 * @param a
	 * @return
	 */
	public static int count(int[] a) {
		/* A: statements executed in constant (growth 1) time */
		Arrays.sort(a);
		int N = a.length;
		int cnt = 0;
		for (int i = 0; 
		/* A */
			/* B: statements executed in linear time */
			i < N; i++) {
			/*/B */
				if(BinarySearch.rank(-a[i], a) > i)
					cnt++; /* E: depends on input */
			}
		return cnt;
	}
	
	/**
	 * Total running time =
	 * 		
	 * 		time to execute A statements multiplied by frequency of execution
	 * 			+ t(A) * 1
	 * 	 	time to execute B statements multiplied by frequency of execution
	 * 			+ t(B) * N
	 * 	  	time to execute C statements multiplied by frequency of execution
	 * 			+ t(C) * N^2
	 * 		time to execute input dependent statements
	 * 			+ t(E) * x ...where x is dependent upon the input data
	 */
	
}

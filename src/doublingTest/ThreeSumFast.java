package doublingTest;

import java.util.Arrays;

public class ThreeSumFast {
	
	/**
	 * Counts the number of triples in the given integer array which sum to zero.
	 * i.e. a + b + c = 0.
	 * 
	 * A mathematic model of the running time is:
	 * 
	 * 	T(N) ~ aN^2logN
	 * 
	 * where a is some machine dependent constant.
	 * 
	 * @param a
	 * @return
	 */
	public static int count(int[] a) {
		Arrays.sort(a); // linearithmic running time NlogN
		int N = a.length;
		int cnt = 0;
		for (int i = 0;	i < N; i++) { // linear running time N
			for (int j = i+1; j < N; j++) { // quadratic running time N^2
					if(BinarySearch.rank(-a[i]-a[j], a) > j) // logarithmic running time logN
						cnt++; // constant execution, frequency depends on input
				}
			}
		return cnt;
	}
	
}

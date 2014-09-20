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
		Arrays.sort(a);
		/* A: statements executed in constant (growth 1) time */
		int N = a.length;
		int cnt = 0;
		for (int i = 0; 
		/* A */
			/* B: statements executed in linear time */
			i < N; i++) {
			for (int j = i+1; 
			/*/B */
				/* C: statement executed in quadratic time */
				j < N; j++) {
				/* C */
					/* D: statements executed in cubic time */
					if(BinarySearch.rank(-a[i]-a[j], a) > j)
						cnt++; /* E: depends on input */
					/* D */
				}
			}
		return cnt;
	}
	
}

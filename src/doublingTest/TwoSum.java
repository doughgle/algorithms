package doublingTest;

public class TwoSum {
	
	/**
	 * Counts the number of pairs in the given integer array which sum to zero.
	 * i.e. a[i] + a[j] = 0.
	 * 
	 * The order of growth is N^2.
	 * A mathematic model of the running time is:
	 * 
	 * 	T(N) ~ aN^2
	 * 
	 * where a is some machine dependent constant.
	 * 
	 * @param a
	 * @return
	 */
	public static int count(int[] a) {
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
					if(a[i] + a[j] == 0)
						cnt++; /* E: depends on input */
				}
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

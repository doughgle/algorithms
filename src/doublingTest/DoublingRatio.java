package doublingTest;

import java.util.Random;

public class DoublingRatio {
	
	public static double timeTrial(int N) {
		int MAX = 1000000;
		Random randomGen = new Random();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = randomGen.nextInt(2 * MAX) - MAX;
		}
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSumFast.count(a);
		return timer.elapsedTime();
	}
	
	public static void main(String[] args) {
		double prev = timeTrial(125);
		for (int N = 250; true; N += N) {
			double time = timeTrial(N);
			System.out.printf("N=%7d T(N)=%7.1f ratio=%5.1f\n", N, time, time/prev);
			prev = time;
		}
	}
}

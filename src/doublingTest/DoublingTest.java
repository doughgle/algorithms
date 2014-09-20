package doublingTest;

import java.util.Random;

public class DoublingTest {
	
	public static double timeTrial(int N) {
		int MAX = 1000000;
		Random randomGen = new Random();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = randomGen.nextInt(2 * MAX) - MAX;
		}
		Stopwatch timer = new Stopwatch();
		int cnt = TwoSum.count(a);
		return timer.elapsedTime();
	}
	
	public static void main(String[] args) {
		for (int N = 250; true; N += N) {
			double time = timeTrial(N);
			System.out.printf("%7d %5.1f\n", N, time);
		}
	}
}

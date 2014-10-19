package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import doublingTest.Stopwatch;

/**
 * A tool for determining the order of growth of an algorithm.
 * 
 * The technique:
 *  + uses an input generator to model the expected input data.
 *  + successively calls the algorithm under test with the input data.
 *  + calculates the ratio of running time to previous running time.
 *  + doubles the input size N.
 */
public class DoublingRatio {
	
	public static double timeTrial(int N) {
		int MAX = 1000000;

		Random randomGen = new Random();
		List<Integer> seq = new ArrayList<>(N);
		for (int i = 0; i < N; i++) {
			seq.add(randomGen.nextInt(2 * MAX) - MAX);
		}
		Stopwatch timer = new Stopwatch();
		
		List<Integer> sortedSeq = MergeSorter.sort(seq);
		return timer.elapsedTime();
	}
	
	public static void main(String[] args) {
		double prevTime = timeTrial(125);
		for (int N = 250; true; N += N) {
			double time = timeTrial(N);
			System.out.printf("N=%7d T(N)=%7.1f ratio=%5.1f\n", N, time, time/prevTime);
			prevTime = time;
		}
	}
}
